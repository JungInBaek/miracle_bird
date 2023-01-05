package com.multi.miraclebird.party;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PartyMemberDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	
	public void createPartyLeader(PartyVO partyVO) {
		mybatis.insert("partyMember.createPartyLeader", partyVO);
	}
	
	public Integer findPartyIdByUserId(Long userId) {
		return mybatis.selectOne("partyMember.findPartyIdByUserId", userId);
	}

}
