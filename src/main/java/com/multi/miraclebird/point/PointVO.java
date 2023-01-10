package com.multi.miraclebird.point;

public class PointVO {
	private int pointId;
	private int pointAmount;
	private int pointPrice;
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
		return "PointVO [pointId=" + pointId + ", pointAmount=" + pointAmount + ", pointPrice=" + pointPrice + "]";
	}
}
