package com.multi.miraclebird.party;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.multi.miraclebird.feed.FeedService;
import com.multi.miraclebird.feed.FeedVO;
import com.multi.miraclebird.party.service.PartyService;
import com.multi.miraclebird.party.vo.PageParam;
import com.multi.miraclebird.party.vo.PageVO;
import com.multi.miraclebird.party.vo.PartyApplicantUserVO;
import com.multi.miraclebird.party.vo.PartyApplicantVO;
import com.multi.miraclebird.party.vo.PartyAttendanceVO;
import com.multi.miraclebird.party.vo.PartyBoardVO;
import com.multi.miraclebird.party.vo.PartyImgVO;
import com.multi.miraclebird.party.vo.PartyMemberUserProfileVO;
import com.multi.miraclebird.party.vo.PartyMemberVO;
import com.multi.miraclebird.party.vo.PartyVO;
import com.multi.miraclebird.store.ProductVO;
import com.multi.miraclebird.store.StoreDAOInterface;

@Controller
@RequestMapping("/party")
public class PartyController {
	
	@Autowired
	private PartyService partyService;
	
	@Autowired
	private FeedService feedService;
	
	@Autowired
	private StoreDAOInterface storeDao;
	
	
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
		PartyVO partyVO = partyService.findPartyByPartyId(partyId);
		model.addAttribute("partyVO", partyVO);
		List<PartyApplicantUserVO> list = partyService.findPartyApplicantUserByPartyId(partyId);
		model.addAttribute("list", list);
		
		return "party/applicants";
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
		PartyVO partyVO = partyService.findPartyByPartyId(partyId);
		List<PartyMemberUserProfileVO> list = partyService.findPartyMemberUserProfileListByPartyId(partyId);
		model.addAttribute("list", list);
		model.addAttribute("partyVO", partyVO);
		
		return "/party/members";
	}
	
	@GetMapping("/feed")
	public String partyFeed(HttpSession session, Model model, PageParam pageParam) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/loginPage";
		} else if(session.getAttribute("partyId") == null) {
			System.out.println("파티에 가입되어 있지 않습니다.");
			return "redirect:/recruit/list";
		}
		
		Integer partyId = (Integer) session.getAttribute("partyId");
		LocalDate today = LocalDate.now();
		pageParam.setPartyId(partyId);
		pageParam.setToday(today);
		Integer total = feedService.getPartyMemberFeedCount(pageParam);
		PageVO pageVO = new PageVO(pageParam, total);
		
		List<FeedVO> list = feedService.findPartyMemberFeed(pageParam);
		
		PartyVO partyVO = partyService.findPartyByPartyId(partyId);
		
		model.addAttribute("partyVO", partyVO);
		model.addAttribute("list", list);
		model.addAttribute("pageVO", pageVO);
		
		return "/party/feed";
	}
	
	@GetMapping("/style")
	public String partyStyle(HttpSession session, Model model) {
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
		PartyImgVO partyImgVO = partyService.findPartyImgByPartyId(partyId);
		PartyVO partyVO = partyService.findPartyByPartyId(partyId); 
		model.addAttribute("partyImgVO", partyImgVO);
		model.addAttribute("partyVO", partyVO);
		
		return "/party/style";
	}
	
	@PostMapping("/img/update")
	public String imgUpdate(HttpSession session, MultipartFile file) throws IOException {
		if (session.getAttribute("userId") == null) {
			return "redirect:/loginPage";
		} else if(session.getAttribute("partyId") == null) {
			System.out.println("파티에 가입되어 있지 않습니다.");
			return "redirect:/recruit/list";
		} else if(!(boolean)session.getAttribute("isLeader")) {
			System.out.println("파티장이 아닙니다.");
			return "redirect:/party/main";
		}
		
		String uploadPath = session.getServletContext().getRealPath("resources/partyImg");
		
		Integer partyId = (Integer) session.getAttribute("partyId");
		PartyImgVO partyImgVO = partyService.findPartyImgByPartyId(partyId);
		if (partyImgVO == null) {
			partyService.savePartyImg(partyId, file, uploadPath);
		} else {
			partyService.updatePartyImg(partyImgVO, file, uploadPath);
		}
		
		return "redirect:/party/style";
	}
	
	@PostMapping("/intro/update")
	public String introUpdate(HttpSession session, @RequestParam String intro) {
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
		PartyVO partyVO = partyService.findPartyByPartyId(partyId);
		partyVO.setIntro(intro);
		
		partyService.updateIntroByPartyId(partyVO);
		
		return "redirect:/party/style";
	}
	
	@GetMapping("/community")
	public String partyCommunity(HttpSession session, Model model) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/loginPage";
		} else if(session.getAttribute("partyId") == null) {
			System.out.println("파티에 가입되어 있지 않습니다.");
			return "redirect:/recruit/list";
		}
		
		Integer partyId = (Integer) session.getAttribute("partyId");
		PartyVO partyVO = partyService.findPartyByPartyId(partyId);
		List<PartyBoardVO> list = partyService.getPartyBoardListByPartyId(partyId);
		model.addAttribute("list", list);
		model.addAttribute("partyVO", partyVO);
		
		return "party/partyCom5";
	}
	
	@GetMapping("/community/{partyBoardId}")
	public String partyBoardDetail(@PathVariable Integer partyBoardId, HttpSession session, Model model) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/loginPage";
		} else if(session.getAttribute("partyId") == null) {
			System.out.println("파티에 가입되어 있지 않습니다.");
			return "redirect:/recruit/list";
		}
		
		Integer partyId = (Integer) session.getAttribute("partyId");
		PartyVO partyVO = partyService.findPartyByPartyId(partyId);
		Long userId = (Long) session.getAttribute("userId");
		PartyBoardVO partyBoardVO = partyService.findPartyBoardById(partyBoardId);
		model.addAttribute("partyBoardVO", partyBoardVO);
		model.addAttribute("userId", userId);
		model.addAttribute("partyVO", partyVO);
		
		return "party/partyComDetail5";
	}
	
	@PostMapping("/community/create")
	public String partyBoardCreate(HttpSession session, Model model, PartyBoardVO partyBoardVO) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/loginPage";
		} else if(session.getAttribute("partyId") == null) {
			System.out.println("파티에 가입되어 있지 않습니다.");
			return "redirect:/recruit/list";
		}
		
		Long userId = (Long) session.getAttribute("userId");
		Integer partyId = (Integer) session.getAttribute("partyId");
		LocalDateTime now = LocalDateTime.now();
		
		
		partyBoardVO.setWriteDate(now);
		partyBoardVO.setUpdateDate(now);
		partyBoardVO.setUserId(userId);
		partyBoardVO.setPartyId(partyId);
		partyService.createPartyBoard(partyBoardVO);
		
		return "redirect:/party/community";
	}
	
	@GetMapping("/community/{partyBoardId}/update")
	public String partyBoardUpdate(HttpSession session, Model model, @PathVariable Integer partyBoardId) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/loginPage";
		} else if(session.getAttribute("partyId") == null) {
			System.out.println("파티에 가입되어 있지 않습니다.");
			return "redirect:/recruit/list";
		}
		
		PartyBoardVO partyBoardVO = partyService.findPartyBoardById(partyBoardId);
		model.addAttribute("partyBoardVO", partyBoardVO);
		
		return "/party/partyComUpdate5";
	}
	
	@ResponseBody
	@GetMapping("/products")
	public List<String> partyProducts(HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return null;
		} else if(session.getAttribute("partyId") == null) {
			return null;
		}
		HashMap<String, String> map = new HashMap<String, String>();
		
		Integer partyId = (Integer) session.getAttribute("partyId");
		List<ProductVO> productVOList = storeDao.findPartyMemberProductByPartyId(partyId);
		
		for (ProductVO productVO : productVOList) {
			String key = productVO.getProductName();
			String value = productVO.getProductClass();
			map.put(key, value);
		}
		
		List<String> list = new ArrayList<>(map.values());
		
		return list;
	}
	
	@ResponseBody
	@GetMapping("/attendance")
	public List<PartyAttendanceVO> partyAttendance(HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return null;
		} else if(session.getAttribute("partyId") == null) {
			return null;
		}
		
		LocalDate today = LocalDate.now();
		Integer partyId = (Integer) session.getAttribute("partyId");
		
		PartyAttendanceVO partyAttendanceVO = new PartyAttendanceVO();
		partyAttendanceVO.setAttendanceDate(today);
		partyAttendanceVO.setPartyId(partyId);
		
		Integer count = feedService.getPartyMemberFeedDistinctCount(partyAttendanceVO);
		partyAttendanceVO.setAttendanceCount(count);
		
		PartyAttendanceVO attendance = partyService.findPartyAttendanceByAttendanceDateAndPartyId(partyAttendanceVO);
		if (attendance == null) {
			partyService.insertPartyAttendance(partyAttendanceVO);
		} else {
			partyAttendanceVO.setPartyAttendanceId(attendance.getPartyAttendanceId());
			partyService.updatePartyAttendance(partyAttendanceVO);
		}
		
		List<PartyAttendanceVO> weekly = partyService.getPartyAttendanceWeeklyByPartyId(partyId);
		
		return weekly;
	}
	
}
