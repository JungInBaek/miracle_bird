package com.multi.miraclebird.party;


public class CreatePartyDTO {

	private String name;
	private String info;
	private String miracleStartTime;
	private String miracleEndTime;
	private String activity;
	
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
	public String getMiracleStartTime() {
		return miracleStartTime;
	}
	public void setMiracleStartTime(String miracleStartTime) {
		this.miracleStartTime = miracleStartTime;
	}
	public String getMiracleEndTime() {
		return miracleEndTime;
	}
	public void setMiracleEndTime(String miracleEndTime) {
		this.miracleEndTime = miracleEndTime;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	
}
