package com.multi.miraclebird.member;

import java.sql.Time;

public class ProfileVO {

	private int profile_id;
	private String member_id;
	private Time miracle_start_time;
	private Time miracle_end_time;
	private String bio;
	private String profile_img;
	
	public int getProfile_id() {
		return profile_id;
	}
	
	public void setProfile_id(int profile_id) {
		this.profile_id = profile_id;
	}
	
	public String getMember_id() {
		return member_id;
	}
	
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	
	public Time getMiracle_start_time() {
		return miracle_start_time;
	}
	
	public void setMiracle_start_time(Time miracle_start_time) {
		this.miracle_start_time = miracle_start_time;
	}
	
	public Time getMiracle_end_time() {
		return miracle_end_time;
	}
	
	public void setMiracle_end_time(Time miracle_end_time) {
		this.miracle_end_time = miracle_end_time;
	}
	
	public String getBio() {
		return bio;
	}
	
	public void setBio(String bio) {
		this.bio = bio;
	}
	
	public String getProfile_img() {
		return profile_img;
	}
	
	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}
	
}
