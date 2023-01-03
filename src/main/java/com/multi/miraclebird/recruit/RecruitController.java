package com.multi.miraclebird.recruit;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.miraclebird.party.PartyService;

@Controller
@RequestMapping("/recruit")
public class RecruitController {

	@Autowired
	private RecruitDAO recruitDao;
	
	@Autowired
	private PartyService partyService;

	@GetMapping("/list")
	public String partyList(HttpServletRequest request, Model model) {
		List<RecruitPartyVO> list = recruitDao.getRecruitPartyList();
		model.addAttribute("list", list);
		
		HttpSession session = request.getSession();
		Long userId = (Long) session.getAttribute("userId");
		
		// 소속 파티 조회
		Integer partyId = null;
		if (userId != null) {
			partyId = partyService.findPartyIdByUserId(userId);
		}
		session.setAttribute("partyId", partyId);

		// 파티 리더 여부
		Boolean isLeader = false;
		if (partyId != null) {
			isLeader = partyService.isLeader(partyId, userId);
		}
		session.setAttribute("isLeader", isLeader);

		return "recruit/list";
	}

	@GetMapping("/create")
	public String createRecruit(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("userId") == null) {
			return "redirect:/loginPage";
		} else if (session.getAttribute("partyId") == null) {
			System.out.println("파티에 가입되어 있지 않습니다.");
			return "redirect:/recruit/list";
		} else if (!(boolean) session.getAttribute("isLeader")) {
			System.out.println("파티장이 아닙니다.");
			return "redirect:/recruit/list";
		}

		return "recruit/create";
	}

}
