package com.multi.miraclebird.feed;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.multi.miraclebird.party.vo.PartyFeedPagingVO;
import com.multi.miraclebird.party.vo.PartyFeedVO;
import com.multi.miraclebird.profile.ProfileVO;

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

	public List<FeedVO> allFeedByUserId(ProfileVO profileVO) {
		return mybatis.selectList("feed.allFeedByUserId", profileVO);
	}
	
	public int countFeedByUserId(Long userId) {
		return mybatis.selectOne("feed.countFeedByUserId", userId);
	}

	public List<FeedJsonVO> allFeedTimeByUserId(ProfileVO profileVO) {
		return mybatis.selectList("feed.allFeedTimeByUserId", profileVO);
	}
	
	public List<PartyFeedVO> findPartyMemberFeed(PartyFeedPagingVO partyFeedPagingVO) {
		return mybatis.selectList("feed.findPartyMemberFeed", partyFeedPagingVO);
	}
	
	public Integer getPartyMemberFeedCount(PartyFeedPagingVO partyFeedPagingVO) {
		return mybatis.selectOne("feed.getPartyMemberFeedCount", partyFeedPagingVO);
	}
}