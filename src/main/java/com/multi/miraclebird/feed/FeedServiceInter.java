package com.multi.miraclebird.feed;

import java.util.List;

import com.multi.miraclebird.party.vo.PageParam;
import com.multi.miraclebird.party.vo.PartyAttendanceVO;
import com.multi.miraclebird.profile.ProfileVO;

public interface FeedServiceInter {

	FeedVO selectFeedByFeedId(FeedVO feedVO);

	List<FeedVO> allMiracleFeedByUserId(ProfileVO profileVO);

	List<FeedVO> allFeedByUserId(ProfileVO profileVO);

	int countFeedByUserId(Long userId);

	List<FeedJsonVO> allFeedTimeByUserId(ProfileVO profileVO);

	// 피드 긍정부정 총합
	EmotionVO totalEmotion(Long userId);

	List<FeedVO> findPartyMemberFeed(PageParam pageParam);

	Integer getPartyMemberFeedCount(PageParam pageParam);

	Integer getPartyMemberFeedDistinctCount(PartyAttendanceVO partyAttendanceVO);

}