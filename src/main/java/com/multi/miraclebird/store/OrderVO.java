package com.multi.miraclebird.store;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class OrderVO {
	private int orderId;
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalDateTime orderDate;
	private Long userId;
	private int productId;
	private String productName;
	private int productPrice;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
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
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	@Override
	public String toString() {
		return "OrderVO [orderId=" + orderId + ", orderDate=" + orderDate + ", userId=" + userId + ", productId="
				+ productId + ", productName=" + productName + ", productPrice=" + productPrice + "]";
	}
	
}
