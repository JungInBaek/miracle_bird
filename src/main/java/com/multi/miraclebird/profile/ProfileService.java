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
import com.multi.miraclebird.feed.FeedDAO;
import com.multi.miraclebird.feed.FeedService;
import com.multi.miraclebird.feed.FeedVO;
import com.multi.miraclebird.user.UserVO;

@Service
public class ProfileService implements ProfileServiceInter {

	@Autowired
	private InstagramApiService instagramApiService;

	@Autowired
	private FeedService feedService;
	
	@Autowired
	private DictionaryService dictionaryService;

	@Autowired
	ProfileDAOInter profileDao;

	@Autowired
	FeedDAO feedDao;

	@Override
	public ProfileVO oneProfile(ProfileVO profileVO) {
		return profileDao.one(profileVO);
	}

	@Override
	public void updateProfile(ProfileVO profileVO) {
		profileDao.update(profileVO);
	}

	// 인스타 api에서 피드 가져옴
	@Override
	public void allFeedInsta(UserVO userVO, ProfileVO profileVO, String path) {
		List<FeedVO> feedList = new ArrayList<>();

		ResponseEntity<Map> feed = instagramApiService.getUserMedia(userVO);
		List<Map> list = (ArrayList) feed.getBody().get("data");
		System.out.println(list);
		for (int i = 0; i < list.size(); i++) {
			FeedVO feedVO = new FeedVO();
			feedVO.setUserId(userVO.getUserId());
			feedVO.setFeedId((String) list.get(i).get("id"));
			feedVO.setMediaType((String) list.get(i).get("media_type"));
			feedVO.setMediaUrl((String) list.get(i).get("media_url"));
			feedVO.setCaption((String) list.get(i).get("caption"));
			feedVO.setUsername((String) list.get(i).get("username"));
			String temp = (String) list.get(i).get("timestamp");

			LocalDateTime tempfeedTime = LocalDateTime.parse(temp,
					DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ"));
			ZonedDateTime zonedFeedTime = ZonedDateTime.of(tempfeedTime, ZoneId.of("UTC"));
			ZonedDateTime seoulFeedTime = zonedFeedTime.withZoneSameInstant(ZoneId.of("Asia/Seoul"));
			LocalDateTime feedDateTime = seoulFeedTime.toLocalDateTime();
			feedVO.setFeedTime(feedDateTime);
//			System.out.println(seoulFeedTime);
			LocalTime feedTime = LocalTime.of(feedVO.getFeedTime().getHour(), feedVO.getFeedTime().getMinute(),
					feedVO.getFeedTime().getSecond());

			FeedVO feedTmpVO = feedService.selectFeedByFeedId(feedVO);
			if ((feedVO.getMediaType().equals("IMAGE") || feedVO.getMediaType().equals("CAROUSEL_ALBUM"))
					&& feedVO.getCaption().contains("#미라클버드") && feedTime.isAfter(profileVO.getMiracleStartTime())
					&& feedTime.isBefore(profileVO.getMiracleEndTime())) {
				int emotionSum = dictionaryService.emotion(feedVO.getCaption(), path);
				feedVO.setEmotionSum(emotionSum);
				if (feedService.selectFeedByFeedId(feedVO) == null) {
					feedDao.createFeed(feedVO);
					int point = profileVO.getMiraclePoint() + 100;
					profileVO.setMiraclePoint(point);
					profileDao.updateMiraclePoint(profileVO);
				} else {
					feedDao.updateFeed(feedVO);
				}
				feedList.add(feedVO);
			}
		}

		// 피드 삭제
		// 인스타에서 가져오는 피드가 최대 1000개이기 때문에 1000개를 넘을 경우 db에 둘지 삭제할지 정해야함
		List<FeedVO> feedTmp = feedDao.allFeedByUserId(profileVO);
		for (int i = 0; i < feedTmp.size(); i++) {
			boolean flag = false;
			for (int j = 0; j < feedList.size(); j++) {
				if (feedList.get(j).getFeedId().equals(feedTmp.get(i).getFeedId())) {
					flag = true;
//					System.out.println("이미있음");
				}
			}
			if (!flag) {
//				System.out.println("삭제");
				feedDao.deleteFeed(feedTmp.get(i));
			}
		}

	}

}