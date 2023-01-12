package com.multi.miraclebird.party.vo;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class PartyAttendanceVO {
	
	private Integer partyAttendanceId;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate attendanceDate;
	private int attendanceCount;
	private Integer partyId;
	
	public Integer getPartyAttendanceId() {
		return partyAttendanceId;
	}
	public void setPartyAttendanceId(Integer partyAttendanceId) {
		this.partyAttendanceId = partyAttendanceId;
	}
	public LocalDate getAttendanceDate() {
		return attendanceDate;
	}
	public void setAttendanceDate(LocalDate attendanceDate) {
		this.attendanceDate = attendanceDate;
	}
	public int getAttendanceCount() {
		return attendanceCount;
	}
	public void setAttendanceCount(int attendanceCount) {
		this.attendanceCount = attendanceCount;
	}
	public Integer getPartyId() {
		return partyId;
	}
	public void setPartyId(Integer partyId) {
		this.partyId = partyId;
	}
	
}
