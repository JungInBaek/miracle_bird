package com.multi.miraclebird.feed;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.miraclebird.user.UserService;
import com.multi.miraclebird.user.UserVO;

@Controller
public class FeedController {

	@Autowired
	FeedService feedService;
	
	@Autowired
	UserService userService;
	
	// 인스타에서 피드 가져오기
	
	// 피드 가져오기
//	@RequestMapping("feed/all")
//	public void allFeed(HttpServletRequest requset, Model model) {
//		HttpSession session = requset.getSession();
//		Long userId = (Long) session.getAttribute("userId");
//		String accessToken = userService.selectAccessTokenByUserId(userId);
//		UserVO userVO = new UserVO();
//		userVO.setUserId(userId);
//		userVO.setAccessToken(accessToken);
//		feedService.allFeed(userVO)
//	}
}
