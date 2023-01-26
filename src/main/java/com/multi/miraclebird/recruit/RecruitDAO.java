package com.multi.miraclebird.recruit;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RecruitDAO implements RecruitDAOInterface {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public List<RecruitPartyVO> getRecruitPartyList() {
		List<RecruitPartyVO> list = mybatis.selectList("recruit.recruitPartyList");
		
		return list;
	}
	
	@Override
	public void createRecruit(RecruitVO recruitVO) {
		mybatis.insert("recruit.createRecruit", recruitVO);
	}
	
	@Override
	public Integer findRecruitIdByPartyId(int partyId) {
		return mybatis.selectOne("recruit.findRecruitIdByPartyId", partyId);
	}

	@Override
	public RecruitPartyVO findRecruitPartyByRecruitId(int recruitId) {
		return mybatis.selectOne("recruit.findRecruitPartyByRecruitId", recruitId);
	}

	@Override
	public void updateRecruit(RecruitVO recruitVO) {
		mybatis.update("recruit.updateRecruit", recruitVO);
	}

	@Override
	public void deleteRecruitById(int recruitId) {
		mybatis.delete("recruit.deleteRecruitById", recruitId);
	}

	@Override
	public List<RecruitPartyVO> getRecruitListByActivity(String activity) {
		return mybatis.selectList("recruit.getRecruitListByActivity", activity);
	}
	
}
