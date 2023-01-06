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

@Controller
@RequestMapping("store")
public class StoreController {
	@Autowired
	StoreDAO dao;
	
	@Autowired
	PageService pageService;
	
	// 상점 메인 화면 및 페이징 처리
	@GetMapping("/productList")
	public void list(HttpServletRequest request, CategoryPageVO vo, Model model) {
		HttpSession session = request.getSession();
		Long userId = (Long) session.getAttribute("userId");
		
		// 페이지 값으로 start, end 값 설정
		vo.setStartEnd(vo.getPage());
		
		// 카테고리별 상품 목록 조회
		List<ProductVO> list = dao.list(vo);
		// 상품 개수 조회
		int count = dao.count(vo);
		int pages = pageService.pages(count);
		int point = dao.myPoint(userId);
		model.addAttribute("cateNum", vo.getCategoryId());
		model.addAttribute("list", list);
		model.addAttribute("pages", pages);
		model.addAttribute("count", count);
		model.addAttribute("point", point);
	}
	
	@PostMapping("/productBuy")
	public String productBuy(HttpServletRequest request, int productId) {
		System.out.println("post로 들어옴");
		// 1.  세션으로 유저 포인트를 가져와서 해당 상품 가격과 비교
		HttpSession session = request.getSession();
		Long userId = (Long) session.getAttribute("userId");
		int myPoint = dao.myPoint(userId);
		int productPoint = dao.productPoint(productId);
		System.out.println(productId);
		
		// 2.  포인트 >= 상품 가격인 경우
		int resultPoint = 0;
		if (myPoint >= productPoint) {
			// 2.1 (유저 포인트-상품 가격) 계산한 값 profile에 저장
			resultPoint = myPoint - productPoint;
			ProfileVO profileVO = new ProfileVO();
			profileVO.setUserId(userId);
			profileVO.setMiraclePoint(resultPoint);
			dao.pointUpdate(profileVO);
			
			// 2.2 order와 user_product에 insert
			OrderVO orderVO = new OrderVO();
			orderVO.setOrderDate(LocalDateTime.now());
			orderVO.setUserId(userId);
			orderVO.setProductId(productId);
			
			dao.orderInsert(orderVO);
			
			UserProductVO userProductVO = new UserProductVO();
			userProductVO.setUserId(userId);
			userProductVO.setProductId(productId);
			
			dao.userProductInsert(userProductVO);
			
			return "redirect:/store/productList?page=1&categoryId=1";
		} // 3.  포인트 <  상품 가격인 경우 상품
		else {
			// 3.1 상품 구매 취소
			request.setAttribute("msg", "포인트가 부족합니다.");
			request.setAttribute("url", "/store/productList?page=1&categoryId=1");
			return "alert";
		}
		
		

	}
}
