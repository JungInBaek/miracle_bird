package com.multi.miraclebird.point;

import java.time.LocalDateTime;

public class ChargeVO {
	private int chargeId;
	private LocalDateTime chargeDate;
	private long userId;
	private int pointId;
	private int pointAmount;
	private int pointPrice;
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
	public int getPointAmount() {
		return pointAmount;
	}
	public void setPointAmount(int pointAmount) {
		this.pointAmount = pointAmount;
	}
	public int getPointPrice() {
		return pointPrice;
	}
	public void setPointPrice(int pointPrice) {
		this.pointPrice = pointPrice;
	}
	@Override
	public String toString() {
		return "ChargeVO [chargeId=" + chargeId + ", chargeDate=" + chargeDate + ", userId=" + userId + ", pointId="
				+ pointId + ", pointAmount=" + pointAmount + ", pointPrice=" + pointPrice + "]";
	}
	
}
