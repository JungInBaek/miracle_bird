package com.multi.miraclebird.feed;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.multi.miraclebird.api.InstagramApiService;
import com.multi.miraclebird.user.UserVO;

@Service
public class FeedService {

	@Autowired
	private InstagramApiService instagramApiService;
	
	public FeedVO allFeed(UserVO userVO, FeedVO feedVO) {
		ResponseEntity<Map> feed = instagramApiService.getUserMedia(userVO);
		
		return null;
	}
}
