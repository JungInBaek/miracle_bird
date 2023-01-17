package com.multi.miraclebird.profile;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileDAO implements ProfileDAOInter {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public void createProfile(ProfileVO profileVO) {
		mybatis.insert("profile.create", profileVO);
	}

	@Override
	public ProfileVO one(ProfileVO profileVO) {
		return mybatis.selectOne("profile.one", profileVO);
	}

	@Override
	public void update(ProfileVO profileVO) {
		mybatis.update("profile.update", profileVO);
	}

	@Override
	public void updateMiraclePoint(ProfileVO profileVO) {
		mybatis.update("profile.updateMiraclePoint", profileVO);
	}
}
