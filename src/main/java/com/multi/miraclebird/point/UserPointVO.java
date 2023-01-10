package com.multi.miraclebird.point;

public class UserPointVO {
	private Long userId;
	private int chargePoint;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public int getChargePoint() {
		return chargePoint;
	}
	public void setChargePoint(int chargePoint) {
		this.chargePoint = chargePoint;
	}
	@Override
	public String toString() {
		return "UserPointVO [userId=" + userId + ", chargePoint=" + chargePoint + "]";
	}
	
	
}
