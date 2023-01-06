package com.multi.miraclebird.profile;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.multi.miraclebird.feed.FeedService;
import com.multi.miraclebird.feed.FeedVO;
import com.multi.miraclebird.user.UserService;
import com.multi.miraclebird.user.UserVO;

@Controller
public class ProfileController {

	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FeedService feedService;

	// 로그인 된 유저 아이디 필요
	// 프로필 조회
	@RequestMapping("profile/one")
	public void oneProfile(HttpServletRequest request, ProfileVO profileVO, Model model) {
//		profileVO.setUserId(17841457620521535L);  // 임시
		HttpSession session = request.getSession();
//		if (session.getAttribute("userId").equals(null)) {
//			return "redirect:/login.jsp";
//		}
		Long userId = (Long) session.getAttribute("userId");
		profileVO.setUserId(userId);
		UserVO userResult = userService.selectUser(userId);
		ProfileVO profileResult = profileService.oneProfile(profileVO);
		model.addAttribute("userVo", userResult);
		model.addAttribute("profileVo", profileResult);
//		return "profile/one";
	}

	@PostMapping("updateProfile")
	public String updateProfile(HttpServletRequest request, MultipartFile file, ProfileVO profileVO) throws Exception {
//		profileVO.setUserId(17841457620521535L);  // 임시
		String savedName = file.getOriginalFilename();
		String uploadPath = request.getSession().getServletContext().getRealPath("resources/profile");
		Long userId = (Long) request.getSession().getAttribute("userId");
		File target = new File(uploadPath + "/" + savedName);
		file.transferTo(target);
		profileVO.setProfileImg(savedName);
		profileVO.setUserId(userId);
		profileService.updateProfile(profileVO);
		return "redirect:myFeed.jsp";
	}

	// 피드 가져오기
	@RequestMapping("profile/allFeed")
	public void allFeed(HttpServletRequest requset, Model model) {
		HttpSession session = requset.getSession();
		Long userId = (Long) session.getAttribute("userId");
		String accessToken = userService.selectAccessTokenByUserId(userId);
		UserVO userVO = new UserVO();
		ProfileVO profileVO = new ProfileVO();
		userVO.setUserId(userId);
		userVO.setAccessToken(accessToken);
		profileVO.setUserId(userId);
		profileVO = profileService.oneProfile(profileVO);
		List<FeedVO> list = profileService.allFeedInsta(userVO, profileVO);
		model.addAttribute("list", list);
	}
	
	// 피드 잔디 구현
	@RequestMapping("profile/feedChart")
	public void feedChart(HttpServletRequest requset, Model model) {
		HttpSession session = requset.getSession();
		Long userId = (Long) session.getAttribute("userId");
		List<FeedVO> list = feedService.allFeedByUserId(userId);
		model.addAttribute("list", list);
	}
}
