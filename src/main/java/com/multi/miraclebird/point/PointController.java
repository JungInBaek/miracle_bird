package com.multi.miraclebird.point;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.miraclebird.store.CategoryPageVO;
import com.multi.miraclebird.store.CategoryVO;
import com.multi.miraclebird.store.OrderVO;
import com.multi.miraclebird.store.StoreServiceInterface;
import com.multi.miraclebird.user.UserService;
import com.multi.miraclebird.user.UserVO;

@Controller
@RequestMapping("store")
public class PointController {
	@Autowired
	PointServiceInterface pointService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	StoreServiceInterface storeService;
	
	// 포인트 목록 조회
	@GetMapping("pointList")
	public String list(HttpServletRequest request, CategoryPageVO vo, Model model) {
		HttpSession session = request.getSession();
		Long userId = (Long) session.getAttribute("userId");
		
		UserVO userVO = userService.selectUser(userId);
		
		List<PointVO> pointVO = pointService.list();
		
		int myPoint = storeService.myPoint(userId);
		
		List<CategoryVO> categoryList = storeService.cateList();
		
		model.addAttribute("cateNum", vo.getCategoryId());
		model.addAttribute("cateList", categoryList);
		model.addAttribute("myPoint", myPoint);
		model.addAttribute("userVO", userVO);
		model.addAttribute("pointVO", pointVO);
		return "/store/pointList";
	}
	
	// 포인트 충전 처리
	@GetMapping("pointBuy")
	public String pointBuy(PointVO pointVO, String username, Model model) {
		model.addAttribute("pointVO", pointVO);
		model.addAttribute("username", username);
		return "/store/pointBuy";
	}
	
	// 포인트 충전 Post 처리
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
	
	// 포인트 충전 내역 페이지
	@GetMapping("chargeList")
	public String chargeList(HttpServletRequest request, Model model) {
		// userId의 충전 내역 불러오기
		HttpSession session = request.getSession();
		Long userId = (Long) session.getAttribute("userId");
	
		List<ChargeVO> chargeList = pointService.chargeList(userId);
	
		// 중복되는 날짜를 제거하기 위해 Set 선언 
		HashSet<String> set = new HashSet<>();
		
		for (int i = 0; i < chargeList.size(); i++) {
			String time = chargeList.get(i).getChargeDate().format(DateTimeFormatter.ISO_LOCAL_DATE);
			set.add(time);
		}
		
		// Set에서 List로 변환
		List<String> dateList = new ArrayList<>(set);
		
		List<LocalDate> date = new ArrayList<LocalDate>();
		for (int i = 0; i < dateList.size(); i++) {
			date.add(LocalDate.parse(dateList.get(i)));
		}
		
		// set 특징 때문에 오름차순 정렬
		Collections.sort(date);
		
		model.addAttribute("date", date);
		model.addAttribute("chargeList", chargeList);
		
		return "/store/chargeList";
	}
}
