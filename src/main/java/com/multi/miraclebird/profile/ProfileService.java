package com.multi.miraclebird.profile;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.swing.text.DateFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.multi.miraclebird.api.InstagramApiService;
import com.multi.miraclebird.feed.FeedVO;
import com.multi.miraclebird.user.UserVO;

@Service
public class ProfileService {
	
	@Autowired
	private InstagramApiService instagramApiService;
	
	@Autowired
	ProfileDAO profileDao;

	public ProfileVO oneProfile(ProfileVO profileVO) {
		return profileDao.one(profileVO);
	}

	public void updateProfile(ProfileVO profileVO) {
		profileDao.update(profileVO);
	}

	public List<FeedVO> allFeed(UserVO userVO, ProfileVO profileVO) {	
		List<FeedVO> feedList = new ArrayList<>();
		
		ResponseEntity<Map> feed = instagramApiService.getUserMedia(userVO);
		List<Map> list = (ArrayList) feed.getBody().get("data");
		System.out.println(list);
//		for (int i=0; i<list.size(); i++) {
//			FeedVO feedVO = new FeedVO();
//			feedVO.setUserId(userVO.getUserId());
//			feedVO.setFeedId((String) list.get(i).get("id"));
//			feedVO.setMediaType((String) list.get(i).get("media_type"));
//			feedVO.setMediaUrl((String) list.get(i).get("media_url"));
//			feedVO.setCaption((String) list.get(i).get("caption"));
//			feedVO.setUsername((String) list.get(i).get("username"));
//			feedVO.setFeedTime((String)list.get(i).get("timestamp"));
//			if (feedVO.getCaption().contains("#미라클버드")) {
//				feedList.add(feedVO);
//			}
//		}
		for (int i=0; i<list.size(); i++) {
			FeedVO feedVO = new FeedVO();
			feedVO.setUserId(userVO.getUserId());
			feedVO.setFeedId((String) list.get(i).get("id"));
			feedVO.setMediaType((String) list.get(i).get("media_type"));
			feedVO.setMediaUrl((String) list.get(i).get("media_url"));
			feedVO.setCaption((String) list.get(i).get("caption"));
			feedVO.setUsername((String) list.get(i).get("username"));
			String temp = (String) list.get(i).get("timestamp");
			
			LocalDateTime tempfeedTime = LocalDateTime.parse(temp, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ"));
			ZonedDateTime zonedFeedTime = ZonedDateTime.of(tempfeedTime, ZoneId.of("UTC"));
			ZonedDateTime seoulFeedTime = zonedFeedTime.withZoneSameInstant(ZoneId.of("Asia/Seoul"));
			feedVO.setFeedTime(seoulFeedTime);
//			System.out.println(seoulFeedTime);
			LocalTime feedTime = LocalTime.of(feedVO.getFeedTime().getHour(), feedVO.getFeedTime().getMinute(), feedVO.getFeedTime().getSecond());
			
			if (feedVO.getMediaType().equals("IMAGE") && feedVO.getCaption().contains("#미라클버드") && feedTime.isAfter(profileVO.getMiracleStartTime()) && feedTime.isBefore(profileVO.getMiracleEndTime())) {
				feedList.add(feedVO);
			}
		}
//		System.out.println(feedList);
		
		return feedList;
	}
	
}
