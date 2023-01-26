package com.multi.miraclebird.recruit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecruitService implements RecruitServiceInterface {

	@Autowired
	private RecruitDAOInterface recruitDao;
	
	@Override
	public List<RecruitPartyVO> getRecruitPartyList() {
		return recruitDao.getRecruitPartyList();
	}
	
	@Override
	public void createRecruit(RecruitVO recruitVO) {
		recruitDao.createRecruit(recruitVO);
	}
	
	@Override
	public Boolean isCreated(int partyId) {
		Boolean isCreated = false;
		Integer recruitId = recruitDao.findRecruitIdByPartyId(partyId);
		if (recruitId != null) {
			isCreated = true;
		}
		
		return isCreated;
	}

	@Override
	public RecruitPartyVO findRecruitPartyByRecruitId(int recruitId) {
		return recruitDao.findRecruitPartyByRecruitId(recruitId);
	}

	@Override
	public void updateRecruit(RecruitVO recruitVO) {
		recruitDao.updateRecruit(recruitVO);
	}

	@Override
	public void deleteRecruitById(int recruitId) {
		recruitDao.deleteRecruitById(recruitId);
	}

	@Override
	public List<RecruitPartyVO> getRecruitListByActivity(String activity) {
		return recruitDao.getRecruitListByActivity(activity);
	}
}
