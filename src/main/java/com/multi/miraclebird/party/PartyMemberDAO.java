package com.multi.miraclebird.party;

import java.util.List;

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
	
	public Integer getPartyMemberCountByPartyId(Integer partyId) {
		return mybatis.selectOne("partyMember.getPartyMemberCountByPartyId", partyId);
	}
	
	public void insertPartyMember(PartyMemberVO partyMemberVO) {
		mybatis.insert("partyMember.insertPartyMember", partyMemberVO);
	}
	
	public List<PartyMemberVO> findPartyMemberListByPartyId(Integer partyId) {
		return mybatis.selectList("partyMember.findPartyMemberListByPartyId", partyId);
	}
	
	public List<PartyMemberUserProfileVO> findPartyMemberUserProfileListByPartyId(Integer partyId) {
		return mybatis.selectList("partyMember.findPartyMemberUserProfileListByPartyId", partyId);
	}

}
