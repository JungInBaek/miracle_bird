package com.multi.miraclebird.feed;

import java.time.LocalDateTime;

public class FeedVO {
	
	private String feedId;
	private Long userId;
	private String mediaType;
	private String mediaUrl;
	private String username;
	private String caption;
	private LocalDateTime feedTime;
	private int emotionSum;
	
	public String getFeedId() {
		return feedId;
	}
	public void setFeedId(String feedId) {
		this.feedId = feedId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getMediaType() {
		return mediaType;
	}
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}
	public String getMediaUrl() {
		return mediaUrl;
	}
	public void setMediaUrl(String mediaUrl) {
		this.mediaUrl = mediaUrl;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public LocalDateTime getFeedTime() {
		return feedTime;
	}
	public void setFeedTime(LocalDateTime feedTime) {
		this.feedTime = feedTime;
	}
	public int getEmotionSum() {
		return emotionSum;
	}
	public void setEmotionSum(int emotionSum) {
		this.emotionSum = emotionSum;
	}
	@Override
	public String toString() {
		return "FeedVO [feedId=" + feedId + ", userId=" + userId + ", mediaType=" + mediaType + ", mediaUrl=" + mediaUrl
				+ ", username=" + username + ", caption=" + caption + ", feedTime=" + feedTime + ", emotionSum="
				+ emotionSum + "]";
	}
	
}
