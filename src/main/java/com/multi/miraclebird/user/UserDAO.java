package com.multi.miraclebird.user;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void createInstagramUser(UserVO userVO) {
		mybatis.insert("user.create", userVO);
	}

	public void updateAccessToken(UserVO userVO) {
		mybatis.update("user.updateToken", userVO);
	}
	
	public UserVO selectByUserId(UserVO userVO) {
		return mybatis.selectOne("user.selectByUserId", userVO);
	}

	public void deleteAccessToken(Long userId) {
		mybatis.update("user.deleteToken", userId);
	}
}
