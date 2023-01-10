package com.multi.miraclebird.profile;

import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

public class ProfileJsonVO {

	private String miracleStartTime;
	private String miracleEndTime;
	private String bio;
	private String profileImg;
	private String username;
	
	public String getMiracleStartTime() {
		return miracleStartTime;
	}
	public void setMiracleStartTime(String miracleStartTime) {
		this.miracleStartTime = miracleStartTime;
	}
	public String getMiracleEndTime() {
		return miracleEndTime;
	}
	public void setMiracleEndTime(String miracleEndTime) {
		this.miracleEndTime = miracleEndTime;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getProfileImg() {
		return profileImg;
	}
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "ProfileJsonVO [miracleStartTime=" + miracleStartTime + ", miracleEndTime=" + miracleEndTime + ", bio="
				+ bio + ", profileImg=" + profileImg + ", username=" + username + "]";
	}
}
