package com.multi.miraclebird.weka;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.multi.miraclebird.recruit.RecruitPartyVO;
import com.multi.miraclebird.recruit.RecruitService;

@Controller
public class RecommendController {
	
	@Autowired
	private recommendService recommendService;
	
	@Autowired
	private RecruitService recruitService;

	@GetMapping("/recommend")
	public String recommendPage(HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/loginPage";
		} else if(session.getAttribute("partyId") != null) {
			System.out.println("파티에 이미 가입되어있습니다.");
			return "redirect:/";
		}
		return "weka/recommend";
	}
	
	@GetMapping("/recommend/result")
	public String recommend(RecommendVO recommendVO, Model model, HttpServletRequest request, String area, String income) throws Exception {
//		String path = request.getSession().getServletContext().getRealPath("/");
		String path = "https://mulicampus-java.s3.ap-northeast-2.amazonaws.com/";
		
		if (area.equals("first")) {
			recommendVO.setAreaFirst(1);
		} else if (area.equals("second")) {
			recommendVO.setAreaSecond(1);
		} else if (area.equals("third")) {
			recommendVO.setAreaThird(1);
		} else if (area.equals("fourth")) {
			recommendVO.setAreaFourth(1);
		}
		
		if (income.equals("first")) {
			recommendVO.setIncomeFirst(1);
		} else if (income.equals("second")) {
			recommendVO.setIncomeSecond(1);
		} else if (income.equals("third")) {
			recommendVO.setIncomeThird(1);
		} else if (income.equals("fourth")) {
			recommendVO.setIncomeFourth(1);
		}
		
		double[] values = {
				recommendVO.getGender(),
				recommendVO.getAge(),
				recommendVO.getAreaFirst(),
				recommendVO.getAreaSecond(),
				recommendVO.getAreaThird(),
				recommendVO.getAreaFourth(),
				recommendVO.getIncomeFirst(),
				recommendVO.getIncomeSecond(),
				recommendVO.getIncomeThird(),
				recommendVO.getIncomeFourth(),
		};
		
		String activity = recommendService.recommend(values, path);
		
		List<RecruitPartyVO> list = recruitService.getRecruitListByActivity(activity);
		
		model.addAttribute("list", list);
		model.addAttribute("activity", activity);
//		model.addAttribute("activity", result[1]);
//		model.addAttribute("img", result[2]);
		
		return "weka/result";
	}
	
}
