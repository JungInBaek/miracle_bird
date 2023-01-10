package com.multi.miraclebird.feed;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FeedDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void createFeed(FeedVO feedVO) {
		mybatis.insert("feed.create", feedVO);
	}
	
	public FeedVO selectFeedByFeedId(FeedVO feedVO) {
		return mybatis.selectOne("feed.selectFeedByFeedId", feedVO);
	}

	public List<FeedVO> allFeedByUserId(Long userId) {
		return mybatis.selectList("feed.allFeedByUserId", userId);
	}
	
	public List<FeedVO> findPartyMemberFeedByPartyId(Integer partyId) {
		return mybatis.selectList("feed.findPartyMemberFeedByPartyId", partyId);
	}
}