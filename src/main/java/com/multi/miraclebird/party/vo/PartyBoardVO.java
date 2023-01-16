package com.multi.miraclebird.party.vo;

import java.time.LocalDateTime;

public class PartyBoardVO {
	
	private Integer partyBoardId;
	private String title;
	private String content;
	private LocalDateTime writeDate;
	private LocalDateTime updateDate;
	private Long userId;
	private Integer partyId;
	private String username;
	
	
	public Integer getPartyBoardId() {
		return partyBoardId;
	}
	public void setPartyBoardId(Integer partyBoardId) {
		this.partyBoardId = partyBoardId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LocalDateTime getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(LocalDateTime writeDate) {
		this.writeDate = writeDate;
	}
	public LocalDateTime getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getPartyId() {
		return partyId;
	}
	public void setPartyId(Integer partyId) {
		this.partyId = partyId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String toString() {
		return "PartyBoardVO [partyBoardId=" + partyBoardId + ", title=" + title + ", content=" + content
				+ ", writeDate=" + writeDate + ", updateDate=" + updateDate + ", userId=" + userId + ", partyId="
				+ partyId + "]";
	}

}
