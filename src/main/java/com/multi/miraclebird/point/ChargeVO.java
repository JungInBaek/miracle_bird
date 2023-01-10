package com.multi.miraclebird.point;

import java.time.LocalDateTime;

public class ChargeVO {
	private int chargeId;
	private LocalDateTime chargeDate;
	private long userId;
	private int pointId;
	public int getChargeId() {
		return chargeId;
	}
	public void setChargeId(int chargeId) {
		this.chargeId = chargeId;
	}
	public LocalDateTime getChargeDate() {
		return chargeDate;
	}
	public void setChargeDate(LocalDateTime chargeDate) {
		this.chargeDate = chargeDate;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public int getPointId() {
		return pointId;
	}
	public void setPointId(int pointId) {
		this.pointId = pointId;
	}
	@Override
	public String toString() {
		return "ChargeVO [chargeId=" + chargeId + ", chargeDate=" + chargeDate + ", userId=" + userId + ", pointId="
				+ pointId + "]";
	}
	
}
