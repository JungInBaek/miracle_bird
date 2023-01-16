package com.multi.miraclebird.weka;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecommendController {
	
	@Autowired
	private recommendService recommendService;

	@GetMapping("/recommend")
	public String recommendPage() {
		
		return "weka/recommend";
	}
	
	@GetMapping("/recommend/result")
	public String recommend(RecommendVO recommendVO, Model model, HttpServletRequest request) throws Exception {
		String path = request.getSession().getServletContext().getRealPath("/");
		
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
		
		String[] result = recommendService.recommend(values, path);
		
		model.addAttribute("partyName", result[0]);
//		model.addAttribute("activity", result[1]);
//		model.addAttribute("img", result[2]);
		
		return "weka/result";
	}
	
}
