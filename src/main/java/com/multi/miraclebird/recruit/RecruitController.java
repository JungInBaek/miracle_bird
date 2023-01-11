package com.multi.miraclebird.recruit;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.miraclebird.party.service.PartyService;
import com.multi.miraclebird.party.vo.PartyApplicantVO;
import com.multi.miraclebird.party.vo.PartyVO;

@Controller
@RequestMapping("/recruit")
public class RecruitController {

	@Autowired
	private RecruitService recruitService;
	
	@Autowired
	private PartyService partyService;

	@GetMapping("/list")
	public String partyList(HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("userId");
		
		// 소속 파티 조회
		Integer partyId = null;
		if (userId != null) {
			partyId = partyService.findPartyIdByUserId(userId);
		}
		session.setAttribute("partyId", partyId);
		
		// 파티 가입 신청 정보
		PartyApplicantVO partyApplicantVO = null;
		if (userId != null && partyId == null) {
			partyApplicantVO = partyService.findPartyApplicantByUserId(userId);
		}
		session.setAttribute("partyApplicantVO", partyApplicantVO);

		// 파티 리더 여부
		Boolean isLeader = false;
		if (userId != null && partyId != null) {
			isLeader = partyService.isLeader(partyId, userId);
		}
		session.setAttribute("isLeader", isLeader);
		
		// 모집글 작성 여부
		Boolean isCreated = false;
		if (partyId != null) {
			isCreated = recruitService.isCreated(partyId);
		}
		session.setAttribute("isCreated", isCreated);
		
		List<RecruitPartyVO> list = recruitService.getRecruitPartyList();
		model.addAttribute("list", list);
		
		return "recruit/list";
	}

	@GetMapping("/create")
	public String createPage(HttpSession session, Model model) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/loginPage";
		} else if (session.getAttribute("partyId") == null) {
			System.out.println("파티에 가입되어 있지 않습니다.");
			return "redirect:/recruit/list";
		} else if (!(boolean) session.getAttribute("isLeader")) {
			System.out.println("파티장이 아닙니다.");
			return "redirect:/recruit/list";
		} else if ((boolean) session.getAttribute("isCreated")) {
			System.out.println("모집글을 이미 작성하셨습니다.");
			return "redirect:/recruit/list";
		}
		
		PartyVO partyVO = partyService.findPartyByPartyId((int) session.getAttribute("partyId"));
		model.addAttribute("partyVO", partyVO);

		return "recruit/create";
	}
	
	@PostMapping("/create")
	public String create(HttpSession session, Model model, RecruitVO recruitVO) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/loginPage";
		} else if (session.getAttribute("partyId") == null) {
			System.out.println("파티에 가입되어 있지 않습니다.");
			return "redirect:/recruit/list";
		} else if (!(boolean) session.getAttribute("isLeader")) {
			System.out.println("파티장이 아닙니다.");
			return "redirect:/recruit/list";
		}
		
		recruitVO.setUserId((Long) session.getAttribute("userId"));
		recruitVO.setPartyId((int) session.getAttribute("partyId"));
		
		recruitService.createRecruit(recruitVO);
		
		return "redirect:/recruit/list";
	}
	
	@GetMapping("/{recruitId}")
	public String recruitDetail(Model model, @PathVariable int recruitId) {
		RecruitPartyVO recruitPartyVO = recruitService.findRecruitPartyByRecruitId(recruitId);
		model.addAttribute("recruitPartyVO", recruitPartyVO);
		
		return "recruit/detail";
	}
	
	@GetMapping("/{recruitId}/update")
	public String recruitUpdatePage(HttpSession session, Model model, @PathVariable int recruitId) {
		RecruitPartyVO recruitPartyVO = recruitService.findRecruitPartyByRecruitId(recruitId);
		if (session.getAttribute("userId") == null) {
			return "redirect:/loginPage";
		} else if (session.getAttribute("partyId") == null) {
			System.out.println("파티에 가입되어 있지 않습니다.");
			return "redirect:/recruit/list";
		} else if (!(boolean) session.getAttribute("isLeader")) {
			System.out.println("파티장이 아닙니다.");
			return "redirect:/recruit/list";
		} else if (!partyService.isLeader(recruitPartyVO.getPartyId(), (Long) session.getAttribute("userId"))) {
			System.out.println("해당 파티의 파티장이 아닙니다.");
			return "redirect:/recruit/list";
		}
		
		model.addAttribute(recruitPartyVO);
		
		return "recruit/update";
	}
	
	@PostMapping("/{recruitId}/update")
	public String recruitUpdate(HttpSession session, Model model, @PathVariable int recruitId, RecruitVO recruitVO) {
		RecruitPartyVO recruitPartyVO = recruitService.findRecruitPartyByRecruitId(recruitId);
		if (session.getAttribute("userId") == null) {
			return "redirect:/loginPage";
		} else if (session.getAttribute("partyId") == null) {
			System.out.println("파티에 가입되어 있지 않습니다.");
			return "redirect:/recruit/list";
		} else if (!(boolean) session.getAttribute("isLeader")) {
			System.out.println("파티장이 아닙니다.");
			return "redirect:/recruit/list";
		} else if (!partyService.isLeader(recruitPartyVO.getPartyId(), (Long) session.getAttribute("userId"))) {
			System.out.println("해당 파티의 파티장이 아닙니다.");
			return "redirect:/recruit/list";
		}

		recruitService.updateRecruit(recruitVO);
		
		return "redirect:/recruit/list";
	}
	
	@GetMapping("/{recruitId}/delete")
	public String recruitDelete(HttpSession session, @PathVariable int recruitId) {
		RecruitPartyVO recruitPartyVO = recruitService.findRecruitPartyByRecruitId(recruitId);
		if (session.getAttribute("userId") == null) {
			return "redirect:/loginPage";
		} else if (session.getAttribute("partyId") == null) {
			System.out.println("파티에 가입되어 있지 않습니다.");
			return "redirect:/recruit/list";
		} else if (!(boolean) session.getAttribute("isLeader")) {
			System.out.println("파티장이 아닙니다.");
			return "redirect:/recruit/list";
		} else if (!partyService.isLeader(recruitPartyVO.getPartyId(), (Long) session.getAttribute("userId"))) {
			System.out.println("해당 파티의 파티장이 아닙니다.");
			return "redirect:/recruit/list";
		}
		
		recruitService.deleteRecruitById(recruitId);
		
		return "redirect:/recruit/list";
	}

}
