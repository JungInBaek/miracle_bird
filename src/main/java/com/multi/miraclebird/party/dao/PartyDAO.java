package com.multi.miraclebird.party.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.multi.miraclebird.party.vo.PartyVO;

@Repository
public class PartyDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void createParty(PartyVO partyVO) {
		mybatis.insert("party.create", partyVO);
	}

	public Long findLeaderIdByUserId(Long userId) {
		return mybatis.selectOne("party.findLeaderIdByUserId", userId);
	}

	public PartyVO findPartyByPartyId(int partyId) {
		return mybatis.selectOne("party.findPartyByPartyId", partyId);
	}
	
}
