package com.multi.miraclebird.party;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.multi.miraclebird.feed.FeedService;
import com.multi.miraclebird.feed.FeedVO;
import com.multi.miraclebird.party.vo.PartyApplicantUserVO;
import com.multi.miraclebird.party.vo.PartyApplicantVO;
import com.multi.miraclebird.party.vo.PartyFeedPagingVO;
import com.multi.miraclebird.party.vo.PartyFeedVO;
import com.multi.miraclebird.party.vo.PartyImgVO;
import com.multi.miraclebird.party.vo.PartyMemberUserProfileVO;
import com.multi.miraclebird.party.vo.PartyMemberVO;
import com.multi.miraclebird.party.vo.PartyVO;

@Controller
@RequestMapping("/party")
public class PartyController {
	
	@Autowired
	private PartyService partyService;
	
	@Autowired
	private FeedService feedService;
	
	
	@GetMapping("/create")
	public String createPartyPage(HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/loginPage";
		} else if(session.getAttribute("partyId") != null) {
			System.out.println("파티에 이미 가입되어있습니다.");
			return "redirect:/recruit/list";
		}
		return "party/create";
	}
	
	@PostMapping("/create")
	public String createParty(PartyVO partyVO, HttpSession session) throws UnsupportedEncodingException {
		if (session.getAttribute("userId") == null) {
			return "redirect:/loginPage";
		} else if(session.getAttribute("partyId") != null) {
			System.out.println("파티에 이미 가입되어있습니다.");
			return "redirect:/recruit/list";
		}
		
		// 파티 생성
		Long userId = (Long) session.getAttribute("userId");
		partyVO.setCreateDate(LocalDateTime.now());
		partyVO.setMaxMemberCount(5);
		partyVO.setLeaderId(userId);
		partyService.createParty(partyVO);
		
		return "redirect:/recruit/list";
	}
	
	@PostMapping("/join")
	public String partyJoin(PartyApplicantVO partyApplicantVO, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/loginPage";
		} else if(session.getAttribute("partyId") != null) {
			System.out.println("파티에 이미 가입되어있습니다.");
			return "redirect:/recruit/list";
		}
		
		partyApplicantVO.setApplicantDate(LocalDateTime.now());
		partyApplicantVO.setUserId((Long) session.getAttribute("userId"));
		partyService.applyJoin(partyApplicantVO);
		
		return "redirect:/recruit/list";
	}
	
	@GetMapping("/main")
	public String roomMainPage(HttpSession session, Model model) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/loginPage";
		} else if(session.getAttribute("partyId") == null) {
			System.out.println("파티에 가입되어 있지 않습니다.");
			return "redirect:/recruit/list";
		}
		
		Integer partyId = (Integer) session.getAttribute("partyId");
		PartyVO partyVO = partyService.findPartyByPartyId(partyId);
		Integer partyMemberCount = partyService.getPartyMemberCountByPartyId(partyId);
		PartyImgVO partyImgVO = partyService.findPartyImgByPartyId(partyId);
		
		model.addAttribute("partyVO", partyVO);
		model.addAttribute("partyMemberCount", partyMemberCount);
		model.addAttribute("partyImgVO", partyImgVO);
		
		return "party/main";
	}
	
	@GetMapping("/join/cancel")
	public String partyJoinCancel(HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/loginPage";
		}
		
		PartyApplicantVO partyApplicantVO = (PartyApplicantVO) session.getAttribute("partyApplicantVO");
		int partyApplicantId = partyApplicantVO.getPartyApplicantId();
		partyService.partyJoinCancel(partyApplicantId);
		
		return "redirect:/recruit/list";
	}
	
	@GetMapping("/applicants")
	public String partyApplicants(HttpSession session, Model model) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/loginPage";
		} else if(session.getAttribute("partyId") == null) {
			System.out.println("파티에 가입되어 있지 않습니다.");
			return "redirect:/recruit/list";
		} else if(!(boolean)session.getAttribute("isLeader")) {
			System.out.println("파티장이 아닙니다.");
			return "redirect:/party/main";
		}
		
		Integer partyId = (Integer) session.getAttribute("partyId");
		List<PartyApplicantUserVO> list = partyService.findPartyApplicantUserByPartyId(partyId);
		model.addAttribute("list", list);
		
		return "party/partyApplicants";
	}
	
	@PostMapping("/accept")
	public String acceptJoin(HttpSession session, PartyApplicantVO partyApplicantVO, PartyMemberVO partyMemberVO) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/loginPage";
		} else if(session.getAttribute("partyId") == null) {
			System.out.println("파티에 가입되어 있지 않습니다.");
			return "redirect:/recruit/list";
		} else if(!(boolean)session.getAttribute("isLeader")) {
			System.out.println("파티장이 아닙니다.");
			return "redirect:/party/main";
		}
		
		System.out.println(partyApplicantVO.getPartyApplicantId());
		System.out.println(partyMemberVO.getPartyMemberId());
		partyMemberVO.setJoinDate(LocalDateTime.now());
		partyService.acceptJoin(partyApplicantVO, partyMemberVO);
		
		return "redirect:/party/applicants";
	}
	
	@PostMapping("/reject")
	public String rejectJoin(HttpSession session, PartyApplicantVO partyApplicantVO) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/loginPage";
		} else if(session.getAttribute("partyId") == null) {
			System.out.println("파티에 가입되어 있지 않습니다.");
			return "redirect:/recruit/list";
		} else if(!(boolean)session.getAttribute("isLeader")) {
			System.out.println("파티장이 아닙니다.");
			return "redirect:/party/main";
		}
		
		partyService.rejectJoin(partyApplicantVO);
		
		return "redirect:/party/applicants";
	}
	
	@GetMapping("/members")
	public String partyMembers(HttpSession session, Model model) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/loginPage";
		} else if(session.getAttribute("partyId") == null) {
			System.out.println("파티에 가입되어 있지 않습니다.");
			return "redirect:/recruit/list";
		}
		
		Integer partyId = (Integer) session.getAttribute("partyId");
		List<PartyMemberUserProfileVO> list = partyService.findPartyMemberUserProfileListByPartyId(partyId);
		model.addAttribute("list", list);
		
		return "/party/members";
	}
	
	@GetMapping("/feed")
	public String partyFeed(HttpSession session, Model model, PartyFeedPagingVO partyFeedPagingVO,
			@RequestParam(value="nowPage", required=false)Integer nowPage,
			@RequestParam(value="cntPerPage", required=false)Integer cntPerPage) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/loginPage";
		} else if(session.getAttribute("partyId") == null) {
			System.out.println("파티에 가입되어 있지 않습니다.");
			return "redirect:/recruit/list";
		}
		
		Integer partyId = (Integer) session.getAttribute("partyId");
		LocalDate today = LocalDate.now();
		Integer total = feedService.getPartyMemberFeedCount(partyFeedPagingVO);
		System.out.println(total);
		
		if (nowPage == null) {
			nowPage = 1;
		}
		if (cntPerPage == null) { 
			cntPerPage = 3;
		}
		
		partyFeedPagingVO = new PartyFeedPagingVO(partyId, today, total, nowPage, cntPerPage);
		
		List<PartyFeedVO> list = feedService.findPartyMemberFeed(partyFeedPagingVO);
		
		model.addAttribute("partyFeedPagingVO", partyFeedPagingVO);
		model.addAttribute("list", list);
		
		System.out.println(list);
		
		System.out.println(list.size());
		for (PartyFeedVO feedVO : list) {
			System.out.println(feedVO);
		}
		
		return "/party/partyFeed";
	}
}
