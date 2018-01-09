package com.internousdev.cherry.dto;

public class LoginDTO {
	private String id;
	private String password;

	private boolean loginFlg = false;

	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id = id;
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
