package com.multi.miraclebird.store;

public class UserProductVO {
	private int usserProductId;
	private Long userId;
	private int productId;
	public int getUsserProductId() {
		return usserProductId;
	}
	public void setUsserProductId(int usserProductId) {
		this.usserProductId = usserProductId;
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
		return "UserProductVO [usserProductId=" + usserProductId + ", userId=" + userId + ", productId=" + productId
				+ "]";
	}
	
	
}
