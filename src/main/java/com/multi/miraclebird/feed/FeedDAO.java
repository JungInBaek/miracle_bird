package com.multi.miraclebird.feed;

import java.time.LocalDateTime;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.multi.miraclebird.party.vo.PartyFeedPagingVO;
import com.multi.miraclebird.party.vo.PartyFeedVO;

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
	
	public List<PartyFeedVO> findPartyMemberFeed(PartyFeedPagingVO partyFeedPagingVO) {
		return mybatis.selectList("feed.findPartyMemberFeed", partyFeedPagingVO);
	}
	
	public Integer getPartyMemberFeedCount(PartyFeedPagingVO partyFeedPagingVO) {
		return mybatis.selectOne("feed.getPartyMemberFeedCount", partyFeedPagingVO);
	}
}