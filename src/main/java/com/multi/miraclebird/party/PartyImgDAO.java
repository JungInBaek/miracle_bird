package com.multi.miraclebird.party;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PartyImgDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public PartyImgVO findPartyImgByPartyId(int partyId) {
		return mybatis.selectOne("partyImg.findPartyImgByPartyId", partyId);
	}
}
