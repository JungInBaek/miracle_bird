package com.multi.miraclebird.user;

import java.time.LocalDateTime;

public class FeedVO {

	private int feed_id;
	private String member_id;
	private String feed_img;
	private String feed_text;
	private LocalDateTime feed_time;
	
	
	public int getFeed_id() {
		return feed_id;
	}
	
	public void setFeed_id(int feed_id) {
		this.feed_id = feed_id;
	}
	
	public String getMember_id() {
		return member_id;
	}
	
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	
	public String getFeed_img() {
		return feed_img;
	}
	
	public void setFeed_img(String feed_img) {
		this.feed_img = feed_img;
	}
	
	public String getFeed_text() {
		return feed_text;
	}
	
	public void setFeed_text(String feed_text) {
		this.feed_text = feed_text;
	}
	
	public LocalDateTime getFeed_time() {
		return feed_time;
	}
	
	public void setFeed_time(LocalDateTime feed_time) {
		this.feed_time = feed_time;
	}
	
}
