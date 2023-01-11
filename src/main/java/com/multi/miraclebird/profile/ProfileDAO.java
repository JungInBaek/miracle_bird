package com.multi.miraclebird.profile;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void createProfile(ProfileVO profileVO) {
		mybatis.insert("profile.create", profileVO);
	}

	public ProfileVO one(ProfileVO profileVO) {
		return mybatis.selectOne("profile.one", profileVO);
	}

	public void update(ProfileVO profileVO) {
		mybatis.update("profile.update", profileVO);
	}

	public void updateMiraclePoint(ProfileVO profileVO) {
		mybatis.update("profile.updateMiraclePoint", profileVO);
	}
}
