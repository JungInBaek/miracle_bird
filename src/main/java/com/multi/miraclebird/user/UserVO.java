package com.multi.miraclebird.user;

import java.time.LocalDateTime;

public class UserVO {

	private Long userId;
	private String accessToken;
	private int expiresIn;
	private LocalDateTime createDate;
	private String username;
	private Role role;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public int getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	public LocalDateTime getExpireDate() {
		return createDate.plusSeconds(expiresIn);
	}
	
	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", accessToken=" + accessToken + ", expiresIn=" + expiresIn
				+ ", createDate=" + createDate + ", username=" + username + ", role=" + role + "]";
	}
	
}
