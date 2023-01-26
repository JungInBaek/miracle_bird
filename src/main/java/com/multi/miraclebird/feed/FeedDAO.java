package com.multi.miraclebird.feed;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.multi.miraclebird.party.vo.PageParam;
import com.multi.miraclebird.party.vo.PartyAttendanceVO;
import com.multi.miraclebird.profile.ProfileVO;

@Repository
public class FeedDAO implements FeedDAOInter {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public void createFeed(FeedVO feedVO) {
		mybatis.insert("feed.create", feedVO);
	}
	
	@Override
	public void updateFeed(FeedVO feedVO) {
		mybatis.update("feed.update", feedVO);
	}
	
	@Override
	public void deleteFeed(FeedVO feedVO) {
		mybatis.delete("feed.delete", feedVO);
	}
	
	@Override
	public FeedVO selectFeedByFeedId(FeedVO feedVO) {
		return mybatis.selectOne("feed.selectFeedByFeedId", feedVO);
	}

	@Override
	public List<FeedVO> allFeedByUserId(ProfileVO profileVO) {
		return mybatis.selectList("feed.allFeedByUserId", profileVO);
	}
	
	@Override
	public int countFeedByUserId(Long userId) {
		return mybatis.selectOne("feed.countFeedByUserId", userId);
	}

	@Override
	public List<FeedJsonVO> allFeedTimeByUserId(ProfileVO profileVO) {
		return mybatis.selectList("feed.allFeedTimeByUserId", profileVO);
	}
	
	@Override
	public int totalEmotion(Long userId) {
		return mybatis.selectOne("feed.totalEmotion", userId);
	}
	
	@Override
	public List<FeedVO> findPartyMemberFeed(PageParam pageParam) {
		return mybatis.selectList("feed.findPartyMemberFeed", pageParam);
	}
	
	@Override
	public Integer getPartyMemberFeedCount(PageParam pageParam) {
		return mybatis.selectOne("feed.getPartyMemberFeedCount", pageParam);
	}
	
	@Override
	public Integer getPartyMemberFeedDistinctCount(PartyAttendanceVO partyAttendanceVO) {
		return mybatis.selectOne("feed.getPartyMemberFeedDistinctCount", partyAttendanceVO);
	}

}