package com.multi.miraclebird.store;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.miraclebird.profile.ProfileVO;
import com.multi.miraclebird.user.UserDAO;
import com.multi.miraclebird.user.UserVO;

@Controller
@RequestMapping("store")
public class StoreController {
	@Autowired
	StoreDAO storeDAO;
	
	@Autowired
	UserDAO userDAO;

	@Autowired
	StoreService storeService;
	
	// 상점 메인 화면 및 페이징 처리
	@GetMapping("/productList")
	public String list(HttpServletRequest request, CategoryPageVO vo, Model model) {
		HttpSession session = request.getSession();
		Long userId = (Long) session.getAttribute("userId");
		
		if (userId == null) {
			request.setAttribute("msg", "로그인이 필요합니다.");
			request.setAttribute("url", "/miraclebird/loginPage");
			return "/store/alert";
		}
		
		// 페이지 값으로 start, end 값 설정
		vo.setStartEnd(vo.getPage());
		
		// 카테고리별 상품 목록 조회
		List<ProductVO> list = storeDAO.list(vo);
		
		// 상품 개수 조회
		int count = storeDAO.count(vo);
		
		// 페이지 처리
		int pages = storeService.pages(count);
		
		// 내 포인트 조회
		int point = storeService.myPoint(userId);
		
		// 카테고리 조회
		List<CategoryVO> categoryList = storeService.cateList();
		
		UserVO userVO = userDAO.selectUser(userId);
		
		model.addAttribute("cateList", categoryList);
		model.addAttribute("userVO", userVO);
		model.addAttribute("cateNum", vo.getCategoryId());
		model.addAttribute("list", list);
		model.addAttribute("pages", pages);
		model.addAttribute("count", count);
		model.addAttribute("point", point);
		return "/store/productList";
	}
	
	@PostMapping("/productBuy")
	public String productBuy(HttpServletRequest request, int productId) {
		System.out.println("post로 들어옴");
		// 1.  세션으로 유저 포인트를 가져와서 해당 상품 가격과 비교
		HttpSession session = request.getSession();
		Long userId = (Long) session.getAttribute("userId");
		int myPoint = storeDAO.myPoint(userId);
		int productPoint = storeDAO.productPoint(productId);

		UserProductVO findProduct = new UserProductVO();
		findProduct.setUserId(userId);
		findProduct.setProductId(productId);
		
		int isProduct = storeService.findProduct(findProduct);
		
		if(isProduct != 0) {
			request.setAttribute("msg", "이미 구매한 상품입니다.");
			request.setAttribute("url", "/miraclebird/store/productList?page=1&categoryId=1");
			return "/store/alert";
		}
		
		// 2.  포인트 >= 상품 가격인 경우
		int resultPoint = 0;
		if (myPoint >= productPoint) {
			// 2.1 (유저 포인트-상품 가격) 계산한 값 profile에 저장
			resultPoint = myPoint - productPoint;
			ProfileVO profileVO = new ProfileVO();
			profileVO.setUserId(userId);
			profileVO.setMiraclePoint(resultPoint);
			storeDAO.pointUpdate(profileVO);
			
			// 2.2 order와 user_product에 insert
			OrderVO orderVO = new OrderVO();
			orderVO.setOrderDate(LocalDateTime.now());
			orderVO.setUserId(userId);
			orderVO.setProductId(productId);
			
			storeDAO.orderInsert(orderVO);
			
			UserProductVO userProductVO = new UserProductVO();
			userProductVO.setUserId(userId);
			userProductVO.setProductId(productId);
			
			storeDAO.userProductInsert(userProductVO);
			
			return "redirect:/store/productList?page=1&categoryId=1";
		} // 3.  포인트 <  상품 가격인 경우 상품
		else {
			// 3.1 상품 구매 취소
			request.setAttribute("msg", "포인트가 부족합니다.");
			request.setAttribute("url", "/miraclebird/store/productList?page=1&categoryId=1");
			return "/store/alert";
		}
	}
}
