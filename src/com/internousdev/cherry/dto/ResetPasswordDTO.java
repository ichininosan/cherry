package com.internousdev.cherry.dto;

public class ResetPasswordDTO {

	private String userId;
	private String password;
	private String passworc;
	private String s;


	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassworc() {
		return passworc;
	}
	public void setPassworc(String passworc) {
		this.passworc = passworc;
	}
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}

}
