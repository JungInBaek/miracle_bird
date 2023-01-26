package com.multi.miraclebird.feed;

import java.util.List;

import com.multi.miraclebird.party.vo.PageParam;
import com.multi.miraclebird.party.vo.PartyAttendanceVO;
import com.multi.miraclebird.profile.ProfileVO;

public interface FeedDAOInter {

	void createFeed(FeedVO feedVO);

	void updateFeed(FeedVO feedVO);

	void deleteFeed(FeedVO feedVO);

	FeedVO selectFeedByFeedId(FeedVO feedVO);

	List<FeedVO> allFeedByUserId(ProfileVO profileVO);

	int countFeedByUserId(Long userId);

	List<FeedJsonVO> allFeedTimeByUserId(ProfileVO profileVO);

	int totalEmotion(Long userId);

	List<FeedVO> findPartyMemberFeed(PageParam pageParam);

	Integer getPartyMemberFeedCount(PageParam pageParam);

	Integer getPartyMemberFeedDistinctCount(PartyAttendanceVO partyAttendanceVO);

}