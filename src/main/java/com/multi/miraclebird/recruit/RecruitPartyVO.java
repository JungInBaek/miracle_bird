package com.multi.miraclebird.recruit;

import java.time.LocalTime;

public class RecruitPartyVO {

	private int recruitId;
	private int partyId;
	private String name;
	private LocalTime miracleStartTime;
	private LocalTime miracleEndTime;
	private String activity;
	private String content;
	
	public int getRecruitId() {
		return recruitId;
	}
	public void setRecruitId(int recruitId) {
		this.recruitId = recruitId;
	}
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
