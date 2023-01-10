package com.multi.miraclebird.store;

public class UserProductVO {
	private int userProductId;
	private Long userId;
	private int productId;
	public int getUserProductId() {
		return userProductId;
	}
	public void setUserProductId(int userProductId) {
		this.userProductId = userProductId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	@Override
	public String toString() {
		return "UserProductVO [userProductId=" + userProductId + ", userId=" + userId + ", productId=" + productId
				+ "]";
	}
	
	
}
