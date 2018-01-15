package com.internousdev.cherry.dto;

public class ResetPasswordDTO {

	private String userId;
	private String password;
	private String s;


	public String getuserId() {
		return userId;
	}
	public void setuserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}

}
