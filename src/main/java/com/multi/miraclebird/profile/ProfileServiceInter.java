package com.multi.miraclebird.profile;

import com.multi.miraclebird.user.UserVO;

public interface ProfileServiceInter {

	ProfileVO oneProfile(ProfileVO profileVO);

	void updateProfile(ProfileVO profileVO);

	// 인스타 api에서 피드 가져옴
	void allFeedInsta(UserVO userVO, ProfileVO profileVO, String path);

}