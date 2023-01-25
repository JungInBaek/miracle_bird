package com.multi.miraclebird.party.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.multi.miraclebird.party.dao.PartyApplicantDAO;
import com.multi.miraclebird.party.dao.PartyAttendanceDAO;
import com.multi.miraclebird.party.dao.PartyBoardDao;
import com.multi.miraclebird.party.dao.PartyDAO;
import com.multi.miraclebird.party.dao.PartyImgDAO;
import com.multi.miraclebird.party.dao.PartyMemberDAO;
import com.multi.miraclebird.party.vo.PartyApplicantUserVO;
import com.multi.miraclebird.party.vo.PartyApplicantVO;
import com.multi.miraclebird.party.vo.PartyAttendanceVO;
import com.multi.miraclebird.party.vo.PartyBoardVO;
import com.multi.miraclebird.party.vo.PartyImgVO;
import com.multi.miraclebird.party.vo.PartyMemberUserProfileVO;
import com.multi.miraclebird.party.vo.PartyMemberVO;
import com.multi.miraclebird.party.vo.PartyVO;

@Service
@Transactional
public class PartyService {
	
	@Autowired
	private PartyDAO partyDao;
	
	@Autowired
	private PartyImgDAO partyImgDao;
	
	@Autowired
	private PartyMemberDAO partyMemberDao;
	
	@Autowired
	private PartyApplicantDAO partyApplicantDao;
	
	@Autowired
	private FileService fileService;

	@Autowired
	private PartyAttendanceDAO partyAttendanceDao;
	
	@Autowired
	private PartyBoardDao partyBoardDao;
	
	
	public Integer createParty(PartyVO partyVO) {
		Integer partyId = partyDao.createParty(partyVO);
		partyMemberDao.createPartyLeader(partyVO);
		return partyId;
	}
	
	public boolean isLeader(Integer PartyId, Long userId) {
		boolean isLeader = false;
		
		Long leaderId = (Long) partyDao.findLeaderIdByUserId(userId);
		if (leaderId != null) {
			isLeader = true;
		}
		
		return isLeader;
	}
	
	public Integer findPartyIdByUserId(Long userId) {
		return partyMemberDao.findPartyIdByUserId(userId);
	}

	public PartyVO findPartyByPartyId(int partyId) {
		return partyDao.findPartyByPartyId(partyId);
	}
	
	public void applyJoin(PartyApplicantVO partyApplicantVO) {
		partyApplicantDao.applyJoin(partyApplicantVO);
	}

	public PartyImgVO findPartyImgByPartyId(Integer partyId) {
		return partyImgDao.findPartyImgByPartyId(partyId);
	}

	public Boolean isApplicant(Long userId) {
		Boolean isApplicant = false;
		Integer partyApplicantId = partyApplicantDao.findPartyApplicantIdByUserId(userId);
		if (partyApplicantId != null) {
			isApplicant = true;
		}
		return isApplicant;
	}

	public PartyApplicantVO findPartyApplicantByUserId(Long userId) {
		return partyApplicantDao.findPartyApplicantByUserId(userId);
	}

	public void partyJoinCancel(int partyApplicantId) {
		partyApplicantDao.deletePartyApplicantById(partyApplicantId);
	}

	public List<PartyApplicantVO> findPartyApplicantsByPartyId(Integer partyId) {
		return partyApplicantDao.findPartyApplicantsByPartyId(partyId);
	}
	
	public Integer getPartyMemberCountByPartyId(Integer partyid) {
		return partyMemberDao.getPartyMemberCountByPartyId(partyid);
	}
	
	public List<PartyApplicantUserVO> findPartyApplicantUserByPartyId(Integer partyId) {
		return partyApplicantDao.findPartyApplicantUserByPartyId(partyId);
	}
	
	public void acceptJoin(PartyApplicantVO partyApplicantVO, PartyMemberVO partyMemberVO) {
		partyApplicantDao.deletePartyApplicantById(partyApplicantVO.getPartyApplicantId());
		partyMemberDao.insertPartyMember(partyMemberVO);
	}

	public void rejectJoin(PartyApplicantVO partyApplicantVO) {
		partyApplicantDao.deletePartyApplicantById(partyApplicantVO.getPartyApplicantId());
	}
	
	public List<PartyMemberVO> findPartyMemberListByPartyId(Integer partyId) {
		return partyMemberDao.findPartyMemberListByPartyId(partyId);
	}
	
	public List<PartyMemberUserProfileVO> findPartyMemberUserProfileListByPartyId(Integer partyId) {
		return partyMemberDao.findPartyMemberUserProfileListByPartyId(partyId);
	}
	
	public void savePartyImg(Integer partyId, MultipartFile file, String upladPath) throws IOException {
		String oriImgName = file.getOriginalFilename();
		String imgName = "";
		
		// 파일 업로드
		if (StringUtils.hasText(oriImgName)) {
			imgName = fileService.uploadFile(upladPath, oriImgName, file.getBytes());
		}
		
		PartyImgVO partyImgVO = new PartyImgVO();
		partyImgVO.setOriImgName(oriImgName);
		partyImgVO.setImgName(imgName);
		partyImgVO.setPartyId(partyId);
		
		partyImgDao.insertPartyImg(partyImgVO);
	}
	
	public void updatePartyImg(PartyImgVO partyImgVO, MultipartFile file, String uploadPath) throws IOException {
		if (!file.isEmpty()) {
			// 기존 이미지 삭제
			if (StringUtils.hasText(partyImgVO.getImgName())) {
				fileService.deleteFile(uploadPath + "/" + partyImgVO.getImgName());
			}
			
			String oriImgName = file.getOriginalFilename();
			String imgName = fileService.uploadFile(uploadPath, oriImgName, file.getBytes());
			partyImgVO.setOriImgName(oriImgName);
			partyImgVO.setImgName(imgName);
			
			partyImgDao.updatePartyImg(partyImgVO);
		}
	}

	public void updateIntroByPartyId(PartyVO partyVO) {
		partyDao.updateIntroByPartyId(partyVO);
	}

	public PartyAttendanceVO findPartyAttendanceByAttendanceDateAndPartyId(PartyAttendanceVO partyAttendanceVO) {
		return partyAttendanceDao.findPartyAttendanceByAttendanceDateAndPartyId(partyAttendanceVO);
	}

	public void insertPartyAttendance(PartyAttendanceVO partyAttendanceVO) {
		partyAttendanceDao.insertPartyAttendance(partyAttendanceVO);
	}

	public void updatePartyAttendance(PartyAttendanceVO partyAttendanceVO) {
		partyAttendanceDao.updatePartyAttendance(partyAttendanceVO);
	}

	public List<PartyAttendanceVO> getPartyAttendanceWeeklyByPartyId(Integer partyId) {
		return partyAttendanceDao.getPartyAttendanceWeeklyByPartyId(partyId);
	}

	public List<PartyBoardVO> getPartyBoardListByPartyId(Integer partyId) {
		return partyBoardDao.getPartyBoardListByPartyId(partyId);
	}

	public void createPartyBoard(PartyBoardVO partyBoardVO) {
		partyBoardDao.createPartyBoard(partyBoardVO);
	}

	public PartyBoardVO findPartyBoardById(Integer partyBoardId) {
		return partyBoardDao.findPartyBoardById(partyBoardId);
	}

	public void updatePartyBoard(PartyBoardVO partyBoardVO) {
		partyBoardDao.updatePartyBoard(partyBoardVO);
	}

	public void deletePartyBoardById(Integer partyBoardId) {
		partyBoardDao.deletePartyBoardById(partyBoardId);
	}
	
}
