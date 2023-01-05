package com.multi.miraclebird.store;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("store")
public class StoreController {
	@Autowired
	StoreDAO dao;
	
	@Autowired
	PageService page;
	
	// 상점 메인 화면 및 페이징 처리
	@GetMapping("/productList")
	public void list(HttpServletRequest request, CategoryPageVO vo, Model model) {
		HttpSession session = request.getSession();
		Long userId = (Long) session.getAttribute("userId");
		
		// 페이지 값으로 start, end 값 설정
		vo.setStartEnd(vo.getPage());
		
		// 카테고리별 
		List<ProductVO> list = dao.list(vo);
		int count = dao.count(vo);
		int pages = page.pages(count);
		int point = dao.myPoint(userId);
		model.addAttribute("cateNum", vo.getCategoryId());
		model.addAttribute("list", list);
		model.addAttribute("pages", pages);
		model.addAttribute("count", count);
		model.addAttribute("point", point);
	}
	
	@GetMapping("/productBuy")
	public void productBuy(HttpServletRequest request, int productId) {
		// 1.  세션으로 유저 포인트를 가져와서 해당 상품 가격과 비교
		HttpSession session = request.getSession();
		Long userId = (Long) session.getAttribute("userId");
		int myPoint = dao.myPoint(userId);
		int productPoint = dao.productPoint(productId);
		// 2.  포인트 >= 상품 가격인 경우
		int result = 0;
		if (myPoint >= productPoint) {
			// 2.1 (유저 포인트-상품 가격) 계산한 값 profile에 저장
			result = myPoint - productPoint;
			System.out.println(result);
			// 2.2 상품 구매 내역과 user_product에 insert
		}		
		// 3.  포인트 <  상품 가격인 경우 상품
		// 3.1 상품 구매 취소

	}
}
