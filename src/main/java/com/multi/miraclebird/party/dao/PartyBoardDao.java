package com.multi.miraclebird.party.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.multi.miraclebird.party.vo.PartyBoardVO;

@Repository
public class PartyBoardDao {
	
	@Autowired
	private SqlSessionTemplate mybatis;

	public List<PartyBoardVO> getPartyBoardListByPartyId(Integer partyId) {
		return mybatis.selectList("partyBoard.getPartyBoardListByPartyId", partyId);
	}

	public void createPartyBoard(PartyBoardVO partyBoardVO) {
		mybatis.insert("partyBoard.createPartyBoard", partyBoardVO);
	}

	public PartyBoardVO findPartyBoardById(Integer partyBoardId) {
		return mybatis.selectOne("partyBoard.findPartyBoardById", partyBoardId);
	}

}
