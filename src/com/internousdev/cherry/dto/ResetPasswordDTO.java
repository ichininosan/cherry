package com.internousdev.cherry.dto;

public class ResetPasswordDTO {

	private String user_id;
	private String password;

	public String getuserId() {
		return user_id;
	}
	public void setuserId(String userId) {
		this.user_id = userId;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
