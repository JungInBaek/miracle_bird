package com.multi.miraclebird.user;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.multi.miraclebird.api.InstagramApiService;


@Service
public class UserService {

	@Autowired
	private InstagramApiService instagramApiService;
	
	@Autowired
	private UserDAO userDao;
	
	public UserVO createInstagramUser(String code) {
		UserVO userVO = new UserVO();
		
		ResponseEntity<Map> shortToken = instagramApiService.getShortTokenAndUserId(code);
		userVO.setUserId((Long) shortToken.getBody().get("user_id"));
		userVO.setAccessToken((String) shortToken.getBody().get("access_token"));
		
		ResponseEntity<Map> longToken = instagramApiService.getLongTokenAndExpires(userVO.getAccessToken());
		userVO.setCreateDate(LocalDateTime.now());
		userVO.setAccessToken((String) longToken.getBody().get("access_token"));
		userVO.setExpiresIn((int) longToken.getBody().get("expires_in"));
		
		ResponseEntity<Map> profile = instagramApiService.getUserProfile(userVO);
		userVO.setUsername((String) profile.getBody().get("username"));
		
		userVO.setRole(Role.USER);
		
		if(selectByUserId(userVO) != null) {
			userDao.updateAccessToken(userVO);
		} else {
			userDao.createInstagramUser(userVO);
		}
		
		return userVO;
	}
	
	public void updateAccessToken(UserVO userVO) {
		userDao.updateAccessToken(userVO);
	}
	
	public UserVO selectByUserId(UserVO userVO) {
		return userDao.selectByUserId(userVO);
	}
}
