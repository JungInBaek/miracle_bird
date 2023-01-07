package com.multi.miraclebird.profile;

import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

public class ProfileJsonVO {

	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalTime miracleStartTime;
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalTime miracleEndTime;
	private String bio;
	private String profileImg;
	private String username;
	
	public LocalTime getMiracleStartTime() {
		return miracleStartTime;
	}
	public void setMiracleStartTime(LocalTime miracleStartTime) {
		this.miracleStartTime = miracleStartTime;
	}
	public LocalTime getMiracleEndTime() {
		return miracleEndTime;
	}
	public void setMiracleEndTime(LocalTime miracleEndTime) {
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
