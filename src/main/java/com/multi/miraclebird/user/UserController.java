package com.multi.miraclebird.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.multi.miraclebird.api.InstagramApiService;


@Controller
public class UserController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private InstagramApiService instagramApiService;
	
	
	@GetMapping("/login")
	public String login(HttpServletRequest request) {
		HttpSession session = request.getSession();

		if (session.getAttribute("user_id") == null) {
			return instagramApiService.getCode();
		}
		return "user/login";
	}

	@GetMapping("/auth")
	public String auth(HttpServletRequest request, String code, Model model) {
		UserVO userVO = userService.createInstagramUser(code);
		HttpSession session = request.getSession();
		session.setAttribute("user_id", userVO.getUserId());
		session.setMaxInactiveInterval(userVO.getExpiresIn());
		
        return "user/login";
	}
}
