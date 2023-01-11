package com.multi.miraclebird.profile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.multi.miraclebird.feed.FeedJsonVO;
import com.multi.miraclebird.feed.FeedService;
import com.multi.miraclebird.feed.FeedVO;
import com.multi.miraclebird.party.vo.PartyImgVO;
import com.multi.miraclebird.party.vo.PartyVO;
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

	@RequestMapping("profile")
	public String myFeed(HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/loginPage";
		}
		return "redirect:profile.jsp";
	}
	
	// 프로필 수정 화면 데이터 조회
	@RequestMapping("oneProfile")
	@ResponseBody
	public ProfileJsonVO one2Profile(HttpServletRequest request, ProfileVO profileVO, Model model) {
		HttpSession session = request.getSession();
		Long userId = (Long) session.getAttribute("userId");
		profileVO.setUserId(userId);
		UserVO userResult = userService.selectUser(userId);
		ProfileVO profileResult = profileService.oneProfile(profileVO);
		ProfileJsonVO profileJson = new ProfileJsonVO();
		profileJson.setUsername(userResult.getUsername());
		profileJson.setBio(profileResult.getBio());
		String startTime = profileResult.getMiracleStartTime().format(DateTimeFormatter.ofPattern("hh:mm"));
		String endTime = profileResult.getMiracleEndTime().format(DateTimeFormatter.ofPattern("hh:mm"));
		profileJson.setMiracleStartTime(startTime);
		profileJson.setMiracleEndTime(endTime);
		profileJson.setProfileImg(profileResult.getProfileImg());
		return profileJson;
	}

	// 프로필 수정
	@PostMapping("updateProfile")
	public String updateProfile(HttpServletRequest request, MultipartFile file, ProfileVO profileVO) throws Exception {
		String savedName = "";
		savedName = file.getOriginalFilename();
		if (!savedName.equals("")) {
			String uploadPath = request.getSession().getServletContext().getRealPath("resources/profile");
			System.out.println("파일있음" + savedName);
			File target = new File(uploadPath + "/" + savedName);
			file.transferTo(target);
		} else {
			savedName = profileVO.getProfileImg();
			System.out.println("파일없음" + savedName);
		}
		Long userId = (Long) request.getSession().getAttribute("userId");
		profileVO.setProfileImg(savedName);
		profileVO.setUserId(userId);
		profileService.updateProfile(profileVO);
		return "redirect:myFeed.jsp";
	}

	// 피드 잔디 구현
//	@RequestMapping("profile/feedChart")
//	public void feedChart(HttpServletRequest requset, ProfileVO profileVO, Model model) {
//		if (profileVO.getUserId() == null) {
//			HttpSession session = requset.getSession();
//			Long userId = (Long) session.getAttribute("userId");
//			profileVO.setUserId(userId);
//		}
////		profileVO = profileService.oneProfile(profileVO);
//		List<FeedVO> list = feedService.allFeedByUserId(profileVO);
//		model.addAttribute("list", list);
//	}
	
	@RequestMapping("profile/testFeedChart")
	@ResponseBody
	public List<FeedJsonVO> testFeedChart(HttpServletRequest requset, ProfileVO profileVO, Model model) {
		Long userId = 17841457620521535L;
		profileVO.setUserId(userId);
		List<FeedJsonVO> feedDate = feedService.allFeedTimeByUserId(profileVO);
		System.out.println(feedDate);
		return feedDate;
	}
}
