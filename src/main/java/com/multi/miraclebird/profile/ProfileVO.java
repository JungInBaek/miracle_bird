package com.multi.miraclebird.profile;

import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

public class ProfileVO {

	private int profileId;
	private Long userId;
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalTime miracleStartTime;
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalTime miracleEndTime;
	private String bio;
	private String profileImg;
	private int miraclePoint;
	
	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
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
	public int getMiraclePoint() {
		return miraclePoint;
	}
	public void setMiraclePoint(int miraclePoint) {
		this.miraclePoint = miraclePoint;
	}
	
	@Override
	public String toString() {
		return "ProfileVO [profileId=" + profileId + ", userId=" + userId + ", miracleStartTime=" + miracleStartTime
				+ ", miracleEndTime=" + miracleEndTime + ", bio=" + bio + ", profileImg=" + profileImg
				+ ", miraclePoint=" + miraclePoint + "]";
	}
}
