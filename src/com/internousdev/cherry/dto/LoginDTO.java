package com.internousdev.cherry.dto;

public class LoginDTO {
	private String userId;
	private String password;

	private boolean loginFlg = false;

	public String getUser_id(){
		return userId;
	}
	public void setUser_id(String userId){
		this.userId = userId;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}


	public boolean getLoginFlg() {
		return loginFlg;
	}

	public void setLoginFlg(boolean loginFlg) {
		this.loginFlg = loginFlg;
	}
}
