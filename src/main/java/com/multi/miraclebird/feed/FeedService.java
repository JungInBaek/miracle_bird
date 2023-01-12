package com.multi.miraclebird.feed;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.miraclebird.party.vo.PageParam;
import com.multi.miraclebird.party.vo.PartyAttendanceVO;
import com.multi.miraclebird.profile.ProfileVO;

@Service
public class FeedService {

	@Autowired
	private FeedDAO feedDao;
	
	public FeedVO selectFeedByFeedId(FeedVO feedVO) {
		return feedDao.selectFeedByFeedId(feedVO);
	}
	
	public List<FeedVO> allMiracleFeedByUserId(ProfileVO profileVO) {
		List<FeedVO> list = feedDao.allFeedByUserId(profileVO);
		List<FeedVO> feedList = new ArrayList<>();
		for (int i=0; i<list.size(); i++) {
			LocalTime feedTime = LocalTime.of(list.get(i).getFeedTime().getHour(), list.get(i).getFeedTime().getMinute(), list.get(i).getFeedTime().getSecond());
			if (feedTime.isAfter(profileVO.getMiracleStartTime()) && feedTime.isBefore(profileVO.getMiracleEndTime())) {
				feedList.add(list.get(i));
			}
		}
		
		return feedList;
	}
	
	public List<FeedVO> allFeedByUserId(ProfileVO profileVO){
		return feedDao.allFeedByUserId(profileVO);
	}
	
	public int countFeedByUserId(Long userId) {
		return feedDao.countFeedByUserId(userId);
	}

	public List<FeedJsonVO> allFeedTimeByUserId(ProfileVO profileVO) {
		List<FeedJsonVO> feedDate = feedDao.allFeedTimeByUserId(profileVO);
		return feedDate;
	}
	
	public List<FeedVO> findPartyMemberFeed(PageParam pageParam) {
		return feedDao.findPartyMemberFeed(pageParam);
	}
	
	public Integer getPartyMemberFeedCount(PageParam pageParam) {
		return feedDao.getPartyMemberFeedCount(pageParam);
	}
	
	public Integer getPartyMemberFeedDistinctCount(PartyAttendanceVO partyAttendanceVO) {
		return feedDao.getPartyMemberFeedDistinctCount(partyAttendanceVO);
	}
}
