package com.multi.miraclebird.recruit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecruitService {

	@Autowired
	private RecruitDAO recruitDao;
	
	public List<RecruitPartyVO> getRecruitPartyList() {
		return recruitDao.getRecruitPartyList();
	}
	
	public void createRecruit(RecruitVO recruitVO) {
		recruitDao.createRecruit(recruitVO);
	}
	
	public Boolean isCreated(int partyId) {
		return recruitDao.isCreated(partyId);
	}

	public RecruitPartyVO findRecruitPartyByRecruitId(int recruitId) {
		return recruitDao.findRecruitPartyByRecruitId(recruitId);
	}
}
