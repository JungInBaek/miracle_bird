package com.multi.miraclebird.party.vo;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class PartyApplicantUserVO {
	
	private int partyApplicantId;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime applicantDate;
	private int partyId;
	private Long userId;
	private String username;
	private String partyName;
	
	public int getPartyApplicantId() {
		return partyApplicantId;
	}
	public void setPartyApplicantId(int partyApplicantId) {
		this.partyApplicantId = partyApplicantId;
	}
	public LocalDateTime getApplicantDate() {
		return applicantDate;
	}
	public void setApplicantDate(LocalDateTime applicantDate) {
		this.applicantDate = applicantDate;
	}
	public int getPartyId() {
		return partyId;
	}
	public void setPartyId(int partyId) {
		this.partyId = partyId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	
}
