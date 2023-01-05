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
	ProductService page;
	
	@GetMapping("/storeMain")
	public String storeMain() {
		return "store/storeMain";
	}
	
	@GetMapping("/productList")
	public void list(CategoryPageVO vo, Model model) {
//		HttpSession session = request.getSession();
//		Long userId = (Long) session.getAttribute("userId");
//		System.out.println(userId);
		vo.setStartEnd(vo.getPage());
		System.out.println(vo.getPage());
		System.out.println(vo.getCategoryId());
		System.out.println("start/end " + vo);
		List<ProductVO> list = dao.list(vo);
		System.out.println(list);
		int count = dao.count();
		int pages = page.pages(count);
		model.addAttribute("cateNum", vo.getCategoryId());
		model.addAttribute("list", list);
		model.addAttribute("pages", pages);
		model.addAttribute("count", count);
	}
}
