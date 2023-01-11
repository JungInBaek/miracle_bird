package com.multi.miraclebird.party.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.multi.miraclebird.party.vo.PartyImgVO;

@Repository
public class PartyImgDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public PartyImgVO findPartyImgByPartyId(int partyId) {
		return mybatis.selectOne("partyImg.findPartyImgByPartyId", partyId);
	}

	public void updatePartyImg(PartyImgVO partyImgVO) {
		mybatis.update("partyImg.updatePartyImg", partyImgVO);
	}

	public void insertPartyImg(PartyImgVO partyImgVO) {
		mybatis.insert("partyImg.insertPartyImg", partyImgVO);
	}
	
}
