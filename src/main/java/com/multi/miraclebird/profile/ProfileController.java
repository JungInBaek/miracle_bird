package com.multi.miraclebird.profile;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ProfileController {

	@Autowired
	private ProfileService profileService;
	
	// 로그인 된 유저 아이디 필요
	// 프로필 조회
	@RequestMapping("profile/one")
	public void oneProfile(HttpServletRequest request, ProfileVO profileVO, Model model) {
//		profileVO.setUserId(17841457620521535L);  // 임시
		HttpSession session = request.getSession();
		long userId = (long) session.getAttribute("userId");
		System.out.println("유저" + userId);
		profileVO.setUserId(userId);
		ProfileVO result = profileService.oneProfile(profileVO);
		model.addAttribute("vo", result);
	}
	
	// 프로필 수정
//	@RequestMapping("updateProfile")
//	public String updateProfile(ProfileVO profileVO) {
//		profileVO.setUserId(17841457620521535L);  // 임시
//		profileService.updateProfile(profileVO);
//		return "redirect:my-profile.jsp";
//	}
	
	@RequestMapping("updateProfile")
	public String updateProfile(HttpServletRequest request, MultipartFile file, ProfileVO profileVO) throws Exception {
		profileVO.setUserId(17841457620521535L);  // 임시
		String savedName = file.getOriginalFilename();
		String uploadPath = request.getSession().getServletContext().getRealPath("resources/profile");
		File target = new File(uploadPath + "/" + savedName);
		file.transferTo(target);
		profileVO.setProfileImg(savedName);
		profileService.updateProfile(profileVO);
		return "redirect:my-profile.jsp";
	}
	
	// 피드 가져오기
	@RequestMapping("profile/allFeed")
	public void allFeed(Model model) {
		
	}
}
