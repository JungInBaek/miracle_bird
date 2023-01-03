package com.multi.miraclebird.user;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.multi.miraclebird.api.InstagramApiService;
import com.multi.miraclebird.party.PartyService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private InstagramApiService instagramApiService;

	@Autowired
	private PartyService partyService;

	@GetMapping("/loginPage")
	public String loginPage() {
		return "user/login";
	}

	@GetMapping("/instaLogin")
	public String login(HttpServletRequest request) {
		HttpSession session = request.getSession();

		// 쿠키 조회
		Cookie[] cookies = request.getCookies();
		Long userId = null;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("userId")) {
					userId = Long.parseLong(cookie.getValue());
				}
			}
		}

		// 엑세스 토큰 조회
		String access_token = userService.selectAccessTokenByUserId(userId);

		if (access_token == null) {
			return instagramApiService.getCode();
		}

		session.setAttribute("userId", userId);

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

		return "redirect:/";
	}

	@GetMapping("/auth")
	public String auth(HttpServletRequest request, HttpServletResponse response, String code) {
		// 최초 로그인 유저 생성
		UserVO userVO = userService.createInstagramUser(code);
		HttpSession session = request.getSession();

		// userId 쿠키 생성
		Long userId = userVO.getUserId();
		Cookie userIdCookie = new Cookie("userId", String.valueOf(userId));
		userIdCookie.setMaxAge(userVO.getExpiresIn());
		response.addCookie(userIdCookie);

		session.setAttribute("userId", userId);

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

		return "redirect:/";
	}
}
