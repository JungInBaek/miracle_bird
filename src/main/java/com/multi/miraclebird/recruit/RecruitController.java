package com.multi.miraclebird.recruit;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.miraclebird.party.PartyDAO;

@Controller
@RequestMapping("/recruit")
public class RecruitController {

	@Autowired
	private RecruitDAO recruitDao;
	
	@Autowired
	private PartyDAO partyDao;
	
	
	@GetMapping("/list")
	public String partyList(Model model) {
		
		List<RecruitPartyVO> list = recruitDao.getRecruitPartyList();
		model.addAttribute("list", list);
		
		return "recruit/list";
	}
	
	@GetMapping("/create")
	public String createRecruit(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("userId") == null) {
			return "redirect:http://localhost:8080/miraclebird/login.jsp";
		} else if(session.getAttribute("partyId") == null) {
			System.out.println("파티에 가입되어 있지 않습니다.");
			return "recruit/list";
		} else {
			Integer partyId = partyDao.findPartyByLeaderId((Long) session.getAttribute("userId"));
			if (partyId == null) {
				System.out.println("파티장이 아닙니다.");
				return "recruit/list";
			}
		}
		
		return "recruit/create";
	}
	
}
