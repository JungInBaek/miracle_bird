package com.multi.miraclebird.recruit;

import java.util.List;

public interface RecruitDAOInterface {

	List<RecruitPartyVO> getRecruitPartyList();

	void createRecruit(RecruitVO recruitVO);

	Integer findRecruitIdByPartyId(int partyId);

	RecruitPartyVO findRecruitPartyByRecruitId(int recruitId);

	void updateRecruit(RecruitVO recruitVO);

	void deleteRecruitById(int recruitId);

	List<RecruitPartyVO> getRecruitListByActivity(String activity);

}