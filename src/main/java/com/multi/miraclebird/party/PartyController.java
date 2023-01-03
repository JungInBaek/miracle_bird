package com.multi.miraclebird.party;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PartyController {
	
	@Autowired
	private PartyService partyService;
	
	
	@GetMapping("party/create")
	public String createPartyPage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("userId") == null) {
			return "redirect:http://localhost:8080/miraclebird/login";
		} else if(session.getAttribute("partyId") != null) {
			System.out.println("파티에 이미 가입되어있습니다.");
			return "recruit/list";
		}
		return "party/create";
	}
	
	@PostMapping("party/create")
	public String createParty(CreatePartyDTO createPartyDTO, HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Long userId = (Long) session.getAttribute("userId");
		PartyVO partyVO = PartyVO.createPartyVO(createPartyDTO, userId);
		partyService.createParty(partyVO);
		
		session.setAttribute("partyId", partyVO.getPartyId());
		
		return "redirect:http://localhost:8080/miraclebird/recruit/list";
	}

}
