package com.lixer.uims.dto;

import com.lixer.uims.entity.User;

public class UserLoginInfo {
	
	private int loginStatus;
	private String loginInfo;
	private User user;
	
	public int getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(int loginStatus) {
		this.loginStatus = loginStatus;
	}
	public String getLoginInfo() {
		return loginInfo;
	}
	public void setLoginInfo(String loginInfo) {
		this.loginInfo = loginInfo;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
