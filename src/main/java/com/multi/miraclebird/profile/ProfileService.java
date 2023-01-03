package com.multi.miraclebird.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
	
	@Autowired
	ProfileDAO profileDao;

	public ProfileVO oneProfile(ProfileVO profileVO) {
		return profileDao.one(profileVO);
	}

	public void updateProfile(ProfileVO profileVO) {
		profileDao.update(profileVO);
	}

}
