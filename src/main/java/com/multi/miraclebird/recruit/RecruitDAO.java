package com.multi.miraclebird.recruit;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RecruitDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<RecruitPartyVO> getRecruitPartyList() {
		List<RecruitPartyVO> list = mybatis.selectList("recruit.recruitPartyList");
		
		return list;
	}
	
	public void createRecruit(RecruitVO recruitVO) {
		mybatis.insert("recruit.createRecruit", recruitVO);
	}
	
	public Integer findRecruitIdByPartyId(int partyId) {
		return mybatis.selectOne("recruit.findRecruitIdByPartyId", partyId);
	}

	public RecruitPartyVO findRecruitPartyByRecruitId(int recruitId) {
		return mybatis.selectOne("recruit.findRecruitPartyByRecruitId", recruitId);
	}

	public void updateRecruit(RecruitVO recruitVO) {
		mybatis.update("recruit.updateRecruit", recruitVO);
	}

	public void deleteRecruitById(int recruitId) {
		mybatis.delete("recruit.deleteRecruitById", recruitId);
	}
	
}
