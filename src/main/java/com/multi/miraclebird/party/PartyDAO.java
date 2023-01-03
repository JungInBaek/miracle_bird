package com.multi.miraclebird.party;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PartyDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void createParty(PartyVO partyVO) {
		mybatis.insert("party.create", partyVO);
	}

	public Integer findPartyByLeaderId(Long userId) {
		return mybatis.selectOne("party.findPartyByLeaderId", userId);
	}
}
