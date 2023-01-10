package com.multi.miraclebird.feed;

import java.util.Date;

public class FeedJsonVO {

	private Date feedTime;
	private int count;
	
	public Date getFeedTime() {
		return feedTime;
	}
	public void setFeedTime(Date feedTime) {
		this.feedTime = feedTime;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "FeedJsonVO [feedTime=" + feedTime + ", count=" + count + "]";
	}
	
}
