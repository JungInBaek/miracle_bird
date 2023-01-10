package com.multi.miraclebird.party.vo;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class PartyMemberVO {
	
	private Integer partyMemberId;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime joinDate;
	private Integer partyId;
	private Long userId;
	
	public Integer getPartyMemberId() {
		return partyMemberId;
	}
	public void setPartyMemberId(Integer partyMemberId) {
		this.partyMemberId = partyMemberId;
	}
	public LocalDateTime getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(LocalDateTime joinDate) {
		this.joinDate = joinDate;
	}
	public Integer getPartyId() {
		return partyId;
	}
	public void setPartyId(Integer partyId) {
		this.partyId = partyId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
