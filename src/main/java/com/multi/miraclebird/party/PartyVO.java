package com.multi.miraclebird.party;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.format.annotation.DateTimeFormat;

public class PartyVO {

	private int partyId;
	private String name;
	private String info;
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalTime miracleStartTime;
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalTime miracleEndTime;
	private String activity;
	private LocalDateTime createDate;
	private int maxMemberCount;
	private Long leaderId;
	
	
	public int getPartyId() {
		return partyId;
	}
	public void setPartyId(int partyId) {
		this.partyId = partyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public LocalTime getMiracleStartTime() {
		return miracleStartTime;
	}
	public void setMiracleStartTime(LocalTime miracleStartTime) {
		this.miracleStartTime = miracleStartTime;
	}
	public LocalTime getMiracleEndTime() {
		return miracleEndTime;
	}
	public void setMiracleEndTime(LocalTime miracleEndTime) {
		this.miracleEndTime = miracleEndTime;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	public int getMaxMemberCount() {
		return maxMemberCount;
	}
	public void setMaxMemberCount(int maxMemberCount) {
		this.maxMemberCount = maxMemberCount;
	}
	public Long getLeaderId() {
		return leaderId;
	}
	public void setLeaderId(Long leaderId) {
		this.leaderId = leaderId;
	}
	
}
