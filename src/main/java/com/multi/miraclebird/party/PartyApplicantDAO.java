package com.multi.miraclebird.party;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PartyApplicantDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void applyJoin(PartyApplicantVO partyApplicantVO) {
		mybatis.insert("partyApplicant.applyJoin", partyApplicantVO);
	}
	
}
