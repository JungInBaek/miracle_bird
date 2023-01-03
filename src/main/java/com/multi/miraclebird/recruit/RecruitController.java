package com.multi.miraclebird.recruit;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recruit")
public class RecruitController {

	@Autowired
	private RecruitDAO recruitDao;
	
	
	@GetMapping("/list")
	public String partyList(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		Integer partyId = (Integer) session.getAttribute("partyId");
		
		boolean isLeader = false;
		if (partyId != null) {
			model.addAttribute("partyId", partyId);
			isLeader = (boolean) session.getAttribute("isLeader");
			model.addAttribute("isLeader", isLeader);
		}
		model.addAttribute("isLeader", isLeader);
		
		List<RecruitPartyVO> list = recruitDao.getRecruitPartyList();
		model.addAttribute("list", list);
		
		return "recruit/list";
	}
	
	@GetMapping("/create")
	public String createRecruit(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("userId") == null) {
			return "redirect:/login";
		} else if(session.getAttribute("partyId") == null) {
			System.out.println("파티에 가입되어 있지 않습니다.");
			return "recruit/list";
		} else {
			boolean isLeader = (boolean) session.getAttribute("isLeader");
			if (!isLeader) {
				System.out.println("파티장이 아닙니다.");
				return "recruit/list";
			}
		}
		
		return "recruit/create";
	}
	
}
