package com.multi.miraclebird.feed;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class FeedVO {
	
	private String feedId;
	private Long userId;
	private String mediaType;
	private String mediaUrl;
	private String username;
	private String caption;
	private ZonedDateTime feedTime;
	
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
	public ZonedDateTime getFeedTime() {
		return feedTime;
	}
	public void setFeedTime(ZonedDateTime feedTime) {
		this.feedTime = feedTime;
	}
	@Override
	public String toString() {
		return "FeedVO [feedId=" + feedId + ", userId=" + userId + ", mediaType=" + mediaType + ", mediaUrl=" + mediaUrl
				+ ", username=" + username + ", caption=" + caption + ", feedTime=" + feedTime + "]";
	}
	
}
