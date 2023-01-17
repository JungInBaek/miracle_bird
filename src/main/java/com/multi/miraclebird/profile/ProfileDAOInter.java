package com.multi.miraclebird.profile;

public interface ProfileDAOInter {

	void createProfile(ProfileVO profileVO);

	ProfileVO one(ProfileVO profileVO);

	void update(ProfileVO profileVO);

	void updateMiraclePoint(ProfileVO profileVO);

}