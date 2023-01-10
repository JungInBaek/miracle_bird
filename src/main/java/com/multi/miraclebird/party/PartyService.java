package com.multi.miraclebird.party;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.multi.miraclebird.party.dao.PartyApplicantDAO;
import com.multi.miraclebird.party.dao.PartyDAO;
import com.multi.miraclebird.party.dao.PartyImgDAO;
import com.multi.miraclebird.party.dao.PartyMemberDAO;
import com.multi.miraclebird.party.vo.PartyApplicantUserVO;
import com.multi.miraclebird.party.vo.PartyApplicantVO;
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
	
	
	public void createParty(PartyVO partyVO) {
		partyDao.createParty(partyVO);
		partyMemberDao.createPartyLeader(partyVO);
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
	
}
