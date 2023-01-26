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
public class FeedService implements FeedServiceInter {

	@Autowired
	private FeedDAOInter feedDao;
	
	@Override
	public FeedVO selectFeedByFeedId(FeedVO feedVO) {
		return feedDao.selectFeedByFeedId(feedVO);
	}
	
	@Override
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
	
	@Override
	public List<FeedVO> allFeedByUserId(ProfileVO profileVO){
		return feedDao.allFeedByUserId(profileVO);
	}
	
	@Override
	public int countFeedByUserId(Long userId) {
		return feedDao.countFeedByUserId(userId);
	}

	@Override
	public List<FeedJsonVO> allFeedTimeByUserId(ProfileVO profileVO) {
		List<FeedJsonVO> feedDate = feedDao.allFeedTimeByUserId(profileVO);
		return feedDate;
	}
	
	// 피드 긍정부정 총합
	@Override
	public EmotionVO totalEmotion(Long userId) {
		EmotionVO emotionVO = new EmotionVO();
		int emotion = feedDao.totalEmotion(userId);
		emotionVO.setTotal(emotion);
		if (emotion > 0) {
			emotionVO.setComent("맑음");
			emotionVO.setImg("sunny.svg");
		} else if (emotion < 0) {
			emotionVO.setComent("비");
			emotionVO.setImg("rainy.svg");
		} else {
			emotionVO.setComent("구름 조금");
			emotionVO.setImg("partlycloudy.svg");
		}
		
		return emotionVO;
	}
	
	@Override
	public List<FeedVO> findPartyMemberFeed(PageParam pageParam) {
		return feedDao.findPartyMemberFeed(pageParam);
	}
	
	@Override
	public Integer getPartyMemberFeedCount(PageParam pageParam) {
		return feedDao.getPartyMemberFeedCount(pageParam);
	}
	
	@Override
	public Integer getPartyMemberFeedDistinctCount(PartyAttendanceVO partyAttendanceVO) {
		return feedDao.getPartyMemberFeedDistinctCount(partyAttendanceVO);
	}

}
