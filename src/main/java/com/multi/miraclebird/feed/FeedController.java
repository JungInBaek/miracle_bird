package com.multi.miraclebird.feed;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.miraclebird.profile.ProfileService;
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
	ProfileService profileService;

	@RequestMapping("myFeed")
	public String myFeed(HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/loginPage";
		}
		return "redirect:myFeed.jsp";
	}

//	// 프로필 조회
//	@RequestMapping("feed/oneProfile")
//	public void oneProfile(HttpServletRequest request, ProfileVO profileVO, Model model) {
//		if (profileVO.getUserId() == null) {
//			HttpSession session = request.getSession();
//			Long userId = (Long) session.getAttribute("userId");
//			profileVO.setUserId(userId);
//		}
//		UserVO userResult = userService.selectUser(profileVO.getUserId());
//		ProfileVO profileResult = profileService.oneProfile(profileVO);
//		int posts = feedService.countFeedByUserId(profileVO.getUserId());
//		model.addAttribute("posts", posts);
//		model.addAttribute("userVo", userResult);
//		model.addAttribute("profileVo", profileResult);
//	}
//
//	// 피드 가져오기
//	@RequestMapping("feed/all")
//	public void allFeed(HttpServletRequest requset, ProfileVO profileVO, UserVO userVO, Model model) {
//		if (profileVO.getUserId() == null) {
//			HttpSession session = requset.getSession();
//			Long userId = (Long) session.getAttribute("userId");
//			profileVO.setUserId(userId);
//			userVO.setUserId(userId);
//		}
//		String accessToken = userService.selectAccessTokenByUserId(profileVO.getUserId());
//		userVO.setAccessToken(accessToken);
//		profileVO = profileService.oneProfile(profileVO);
//		// 인스타 api호출과 db select 분리
//		profileService.allFeedInsta(userVO, profileVO);
//		List<FeedVO> list = feedService.allMiracleFeedByUserId(profileVO);
//		model.addAttribute("list", list);
//	}
}
