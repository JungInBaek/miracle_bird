package com.multi.miraclebird.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.multi.miraclebird.api.InstagramApiService;
import com.multi.miraclebird.party.PartyMemberDAO;


@Controller
public class UserController {
	
	@Autowired
	private PartyMemberDAO partyMemberDao;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private InstagramApiService instagramApiService;
	
	
	@GetMapping("/login")
	public String loginPage() {
		return "user/login";
	}
	
	@GetMapping("/instaLogin")
	public String login(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		if (session.getAttribute("userId") == null) {
			return instagramApiService.getCode();
		} else {
			Long userId = (Long) session.getAttribute("userId");
			model.addAttribute("userId", userId);
			Integer partyId = (Integer) session.getAttribute("partyId");
			if (partyId != null) {
				model.addAttribute(partyId);
			}
		}
		return "home";
	}

	@GetMapping("/auth")
	public String auth(HttpServletRequest request, String code, Model model) {
		UserVO userVO = userService.createInstagramUser(code);
		HttpSession session = request.getSession();
		
		session.setAttribute("userId", userVO.getUserId());
		session.setMaxInactiveInterval(userVO.getExpiresIn());
		
		Integer partyId = partyMemberDao.findPartyIdByUserId(userVO.getUserId());
		if(partyId != null) {
			session.setAttribute("partyId", partyId);
		}
		
        return "redirect:http://localhost:8080/miraclebird/";
	}
}
