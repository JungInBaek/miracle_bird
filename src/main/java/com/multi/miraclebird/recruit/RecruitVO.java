package com.multi.miraclebird.recruit;

public class RecruitVO {

	private int recruitId;
	private String content;
	private Long userId;
	private int partyId;
	
	
	public int getRecruitId() {
		return recruitId;
	}
	public void setRecruitId(int recruitId) {
		this.recruitId = recruitId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public int getPartyId() {
		return partyId;
	}
	public void setPartyId(int partyId) {
		this.partyId = partyId;
	}
	
	@Override
	public String toString() {
		return "RecruitVO [recruitId=" + recruitId + ", content=" + content + ", userId=" + userId + ", partyId="
				+ partyId + "]";
	}
	
}
