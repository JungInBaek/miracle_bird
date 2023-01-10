package com.multi.miraclebird.point;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.miraclebird.store.StoreService;
import com.multi.miraclebird.user.UserService;
import com.multi.miraclebird.user.UserVO;

@Controller
@RequestMapping("store")
public class PointController {
	@Autowired
	PointService pointService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	StoreService storeService;
	
	@GetMapping("pointList")
	public String list(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		Long userId = (Long) session.getAttribute("userId");
		
		UserVO userVO = userService.selectUser(userId);
		
		List<PointVO> pointVO = pointService.list();
		
		int myPoint = storeService.myPoint(userId);
		
		model.addAttribute("myPoint", myPoint);
		model.addAttribute("userVO", userVO);
		model.addAttribute("pointVO", pointVO);
		return "/store/pointList";
	}
	
//	@GetMapping("pointBuying")
//	public void pointBuying(HttpServletRequest request, String pointId, Model model) {
//		System.out.println(pointId);
//		int pointId2 = Integer.parseInt(pointId.trim());
//		System.out.println(pointId2);
//		HttpSession session = request.getSession();
//		Long userId = (Long) session.getAttribute("userId");
//		
//		UserVO userVO = userService.selectUser(userId);
//		
//		PointVO pointVO = pointService.one(pointId2);
//		
//		model.addAttribute("pointVO", pointVO);
//	}
	
	@GetMapping("pointBuy")
	public String pointBuy(PointVO pointVO, String username, Model model) {
		model.addAttribute("pointVO", pointVO);
		model.addAttribute("username", username);
		return "/store/pointBuy";
	}
	
	@PostMapping("pointBuying")
	public void pointBuy(HttpServletRequest request, int pointId) {
		HttpSession session = request.getSession();
		Long userId = (Long) session.getAttribute("userId");
		
		ChargeVO chargeVO = new ChargeVO();
		chargeVO.setChargeDate(LocalDateTime.now());
		chargeVO.setPointId(pointId);
		chargeVO.setUserId(userId);
		
		// 값이 들어왔을 때
		// 1. charge 테이블에 내역 추가
		pointService.chargeInsert(chargeVO);
		
		// 2. DB에 포인트 충전
		int chargePoint = pointService.findPoint(pointId);
		
		UserPointVO userPointVO = new UserPointVO();
		userPointVO.setUserId(userId);
		userPointVO.setChargePoint(chargePoint);
		
		pointService.pointCharge(userPointVO);
		
		/*
		 * request.setAttribute("msg", "포인트 충전이 완료되었습니다!"); request.setAttribute("url",
		 * "/miraclebird/store/pointList"); return "/store/alert";
		 */
	}
}
