package com.multi.miraclebird.feed;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.miraclebird.profile.ProfileServiceInter;
import com.multi.miraclebird.profile.ProfileVO;
import com.multi.miraclebird.user.UserService;
import com.multi.miraclebird.user.UserVO;

@Controller
public class FeedController {

	@Autowired
	FeedService feedService;

	@Autowired
	UserService userService;

	@Autowired
	ProfileServiceInter profileService;

	@RequestMapping("myFeed")
	public String myFeed(HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/loginPage";
		}
		return "redirect:myFeed.jsp";
	}

	// 프로필 조회 ajax
	@RequestMapping("feed/oneProfile")
	public void oneProfile(HttpServletRequest request, ProfileVO profileVO, Model model) {
		HttpSession session = request.getSession();
		Long userId = (Long) session.getAttribute("userId");
		profileVO.setUserId(userId);
		UserVO userResult = userService.selectUser(profileVO.getUserId());
		ProfileVO profileResult = profileService.oneProfile(profileVO);
		int posts = feedService.countFeedByUserId(profileVO.getUserId());
		model.addAttribute("posts", posts);
		model.addAttribute("userVo", userResult);
		model.addAttribute("profileVo", profileResult);
	}

	// db에서 피드 가져오기
	@RequestMapping("feed/all")
	public void allFeed(HttpServletRequest request, ProfileVO profileVO, UserVO userVO, Model model) {
		HttpSession session = request.getSession();
		Long userId = (Long) session.getAttribute("userId");
		profileVO.setUserId(userId);
		userVO.setUserId(userId);
		String accessToken = userService.selectAccessTokenByUserId(profileVO.getUserId());
		userVO.setAccessToken(accessToken);
		profileVO = profileService.oneProfile(profileVO);
		// 인스타 api호출
		profileService.allFeedInsta(userVO, profileVO);
		// db select 분리
		List<FeedVO> list = feedService.allMiracleFeedByUserId(profileVO);
		// 피드 긍정부정 총합
		EmotionVO emotionVO = feedService.totalEmotion(userId);
		model.addAttribute("list", list);
		model.addAttribute("emotionVo", emotionVO);
	}
	
	// 인스타에서 피드 가져오기 ajax
	@RequestMapping("feed/insta")
	public void instaFeed(HttpServletRequest request, ProfileVO profileVO, UserVO userVO) {
		HttpSession session = request.getSession();
		Long userId = (Long) session.getAttribute("userId");
		profileVO.setUserId(userId);
		userVO.setUserId(userId);
		String accessToken = userService.selectAccessTokenByUserId(userId);
		userVO.setAccessToken(accessToken);
		profileVO = profileService.oneProfile(profileVO);
		profileService.allFeedInsta(userVO, profileVO);
	}
	
}
