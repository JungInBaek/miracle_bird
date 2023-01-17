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
		Boolean isCreated = false;
		Integer recruitId = recruitDao.findRecruitIdByPartyId(partyId);
		if (recruitId != null) {
			isCreated = true;
		}
		
		return isCreated;
	}

	public RecruitPartyVO findRecruitPartyByRecruitId(int recruitId) {
		return recruitDao.findRecruitPartyByRecruitId(recruitId);
	}

	public void updateRecruit(RecruitVO recruitVO) {
		recruitDao.updateRecruit(recruitVO);
	}

	public void deleteRecruitById(int recruitId) {
		recruitDao.deleteRecruitById(recruitId);
	}

	public List<RecruitPartyVO> getRecruitListByActivity(String activity) {
		return recruitDao.getRecruitListByActivity(activity);
	}
}
