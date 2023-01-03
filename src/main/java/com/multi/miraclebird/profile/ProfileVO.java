package com.multi.miraclebird.profile;

import java.sql.Time;

public class ProfileVO {

	private int profileId;
	private long userId;
	private Time miracleStartTime;
	private Time miracleEndTime;
	private String bio;
	private String profileImg;
	private int miraclePoint;
	
	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public Time getMiracleStartTime() {
		return miracleStartTime;
	}
	public void setMiracleStartTime(Time miracleStartTime) {
		this.miracleStartTime = miracleStartTime;
	}
	public Time getMiracleEndTime() {
		return miracleEndTime;
	}
	public void setMiracleEndTime(Time miracleEndTime) {
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
