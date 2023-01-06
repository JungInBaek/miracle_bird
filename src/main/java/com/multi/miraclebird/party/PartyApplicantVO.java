package com.multi.miraclebird.party;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class PartyApplicantVO {

	private int partyApplicantId;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime applicantDate;
	private int partyId;
	private Long userId;
	
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
	
}
