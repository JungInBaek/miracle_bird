package com.multi.miraclebird.party;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/party")
public class PartyController {
	
	@Autowired
	private PartyService partyService;
	
	
	@GetMapping("/create")
	public String createPartyPage(HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/loginPage";
		} else if(session.getAttribute("partyId") != null) {
			System.out.println("파티에 이미 가입되어있습니다.");
			return "redirect:/recruit/list";
		}
		return "party/create";
	}
	
	@PostMapping("/create")
	public String createParty(PartyVO partyVO, HttpSession session) throws UnsupportedEncodingException {
		if (session.getAttribute("userId") == null) {
			return "redirect:/loginPage";
		} else if(session.getAttribute("partyId") != null) {
			System.out.println("파티에 이미 가입되어있습니다.");
			return "redirect:/recruit/list";
		}
		
		// 파티 생성
		Long userId = (Long) session.getAttribute("userId");
		partyVO.setCreateDate(LocalDateTime.now());
		partyVO.setMaxMemberCount(5);
		partyVO.setLeaderId(userId);
		partyService.createParty(partyVO);
		
		return "redirect:/recruit/list";
	}
	
	@PostMapping("/join")
	public String partyJoin(PartyApplicantVO partyApplicantVO, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/loginPage";
		} else if(session.getAttribute("partyId") != null) {
			System.out.println("파티에 이미 가입되어있습니다.");
			return "redirect:/recruit/list";
		}
		
		partyApplicantVO.setApplicantDate(LocalDateTime.now());
		partyApplicantVO.setUserId((Long) session.getAttribute("userId"));
		partyService.applyJoin(partyApplicantVO);
		
		return "redirect:/recruit/list";
	}
	
	@GetMapping("/main")
	public String roomMainPage(HttpSession session, Model model) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/loginPage";
		} else if(session.getAttribute("partyId") == null) {
			System.out.println("파티에 가입되어 있지 않습니다.");
			return "redirect:/recruit/list";
		}
		
		Integer partyId = (Integer) session.getAttribute("partyId");
		PartyVO partyVO = partyService.findPartyByPartyId(partyId);
		Integer partyMemberCount = partyService.getPartyMemberCountByPartyId(partyId);
		PartyImgVO partyImgVO = partyService.findPartyImgByPartyId(partyId);
		
		model.addAttribute("partyVO", partyVO);
		model.addAttribute("partyMemberCount", partyMemberCount);
		model.addAttribute("partyImgVO", partyImgVO);
		
		return "party/main";
	}
	
	@GetMapping("/join/cancel")
	public String partyJoinCancel(HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/loginPage";
		}
		
		PartyApplicantVO partyApplicantVO = (PartyApplicantVO) session.getAttribute("partyApplicantVO");
		int partyApplicantId = partyApplicantVO.getPartyApplicantId();
		partyService.partyJoinCancel(partyApplicantId);
		
		return "redirect:/recruit/list";
	}
	
	@GetMapping("/applicants")
	public String partyApplicants(HttpSession session, Model model) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/loginPage";
		} else if(session.getAttribute("partyId") == null) {
			System.out.println("파티에 가입되어 있지 않습니다.");
			return "redirect:/recruit/list";
		}
		
		Integer partyId = (Integer) session.getAttribute("partyId");
		List<PartyApplicantVO> list = partyService.findPartyApplicantsByPartyId(partyId);
		model.addAttribute("list", list);
		
		return "party/partyApplicants";
	}
}
