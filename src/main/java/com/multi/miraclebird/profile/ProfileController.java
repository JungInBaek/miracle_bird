package com.multi.miraclebird.profile;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.multi.miraclebird.feed.FeedService;
import com.multi.miraclebird.feed.FeedVO;
import com.multi.miraclebird.party.PartyImgVO;
import com.multi.miraclebird.party.PartyVO;
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

	@RequestMapping("myFeed")
	public String myFeed(HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/loginPage";
		}
		return "redirect:myFeed.jsp";
	}
	
	// 프로필 조회
	@RequestMapping("profile/one")
	public void oneProfile(HttpServletRequest request, ProfileVO profileVO, Model model) {
		HttpSession session = request.getSession();
		Long userId = (Long) session.getAttribute("userId");
		profileVO.setUserId(userId);
		UserVO userResult = userService.selectUser(userId);
		ProfileVO profileResult = profileService.oneProfile(profileVO);
		model.addAttribute("userVo", userResult);
		model.addAttribute("profileVo", profileResult);
	}
	
	@RequestMapping("profile/one2")
	public void one2Profile(HttpServletRequest request, ProfileVO profileVO, Model model) {
		HttpSession session = request.getSession();
		Long userId = (Long) session.getAttribute("userId");
		profileVO.setUserId(userId);
		UserVO userResult = userService.selectUser(userId);
		ProfileVO profileResult = profileService.oneProfile(profileVO);
		model.addAttribute("userVo", userResult);
		model.addAttribute("profileVo", profileResult);
	}

	@PostMapping("updateProfile")
	public String updateProfile(HttpServletRequest request, MultipartFile file, ProfileVO profileVO) throws Exception {
		String savedName = "";
		if (file != null) {
			savedName = file.getOriginalFilename();
			String uploadPath = request.getSession().getServletContext().getRealPath("resources/profile");
			File target = new File(uploadPath + "/" + savedName);
			file.transferTo(target);
		} else {
			savedName = "profile.png";
		}
		Long userId = (Long) request.getSession().getAttribute("userId");
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
