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
	
	public UserVO selectUserByUserId(UserVO userVO) {
		return mybatis.selectOne("user.selectUserByUserId", userVO);
	}

	public void deleteAccessToken(Long userId) {
		mybatis.update("user.deleteToken", userId);
	}
	
	public String selectAccessTokenByUserId(Long userId) {
		return mybatis.selectOne("user.selectAccessTokenByUserId", userId);
	}
	
	public UserVO selectUser(Long userId) {
		return mybatis.selectOne("user.selectUser", userId);
	}
}
