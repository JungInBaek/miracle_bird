package com.multi.miraclebird.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.multi.miraclebird.api.InstagramApiService;
import com.multi.miraclebird.party.PartyMemberDAO;
import com.multi.miraclebird.party.PartyService;


@Controller
public class UserController {
	
	@Autowired
	private PartyService partyService;
	
	@Autowired
	private PartyMemberDAO partyMemberDao;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private InstagramApiService instagramApiService;
	
	
	@GetMapping("/loginPage")
	public String loginPage() {
		return "user/login";
	}
	
	@GetMapping("/instaLogin")
	public String login(HttpServletRequest request, RedirectAttributes attr) {
		HttpSession session = request.getSession();
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return instagramApiService.getCode();
		}
//		model.addAttribute("userId", userId);
		attr.addFlashAttribute("userId", userId);
		
		boolean isLeader = false;
		Integer partyId = (Integer) session.getAttribute("partyId");
		if (partyId != null) {
//			model.addAttribute(partyId);
			attr.addFlashAttribute("partyId", partyId);
			isLeader = (boolean) session.getAttribute("isLeader");
		}
		session.setAttribute("isLeader", isLeader);
		
		return "redirect:/";
	}

	@GetMapping("/auth")
	public String auth(HttpServletRequest request, String code) {
		UserVO userVO = userService.createInstagramUser(code);
		HttpSession session = request.getSession();
		
		Long userId = userVO.getUserId();
		session.setAttribute("userId", userId);
		session.setMaxInactiveInterval(userVO.getExpiresIn());
		
		boolean isLeader = false;
		Integer partyId = partyMemberDao.findPartyIdByUserId(userVO.getUserId());
		if(partyId != null) {
			session.setAttribute("partyId", partyId);
			isLeader = partyService.isLeader(partyId, userId);
		}
		session.setAttribute("isLeader", isLeader);

        return "redirect:/";
	}
}
