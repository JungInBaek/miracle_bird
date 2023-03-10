package com.multi.miraclebird.party.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.multi.miraclebird.party.vo.PartyApplicantUserVO;
import com.multi.miraclebird.party.vo.PartyApplicantVO;

@Repository
public class PartyApplicantDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void applyJoin(PartyApplicantVO partyApplicantVO) {
		mybatis.insert("partyApplicant.applyJoin", partyApplicantVO);
	}

	public Integer findPartyApplicantIdByUserId(Long userId) {
		return mybatis.selectOne("partyApplicant.findPartyApplicantIdByUserId", userId);
	}

	public PartyApplicantVO findPartyApplicantByUserId(Long userId) {
		return mybatis.selectOne("partyApplicant.findPartyApplicantByUserId", userId);
	}

	public void deletePartyApplicantById(int partyApplicantId) {
		mybatis.delete("deletePartyApplicantById", partyApplicantId);
	}

	public List<PartyApplicantVO> findPartyApplicantsByPartyId(Integer partyId) {
		return mybatis.selectList("partyApplicant.findPartyApplicantsByPartyId", partyId);
	}
	
	public List<PartyApplicantUserVO> findPartyApplicantUserByPartyId(Integer partyId) {
		return mybatis.selectList("partyApplicant.findPartyApplicantUserByPartyId", partyId);
	}
	
}
