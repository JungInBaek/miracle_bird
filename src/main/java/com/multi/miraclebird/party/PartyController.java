package com.multi.miraclebird.party;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	public String joinParty(HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/loginPage";
		} else if(session.getAttribute("partyId") != null) {
			System.out.println("파티에 이미 가입되어있습니다.");
			return "redirect:/recruit/list";
		}
		
		
		
		return "redirect:/recruit/list";
	}
	

}
