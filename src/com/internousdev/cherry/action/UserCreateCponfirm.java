package com.internousdev.cherry.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class UserCreateCponfirm extends ActionSupport implements SessionAware{
	private String user_id;
	private String password;

	public Map<String,Object> session;
	private String result;
	private String errorMessage;

	public String execute(){
		result = SUCCESS;

		if(!(user_id.equals("")) && !(password.equals(""))){
			session.put("user_id", user_id);
			session.put("password", password);
		}else{
			setErrorMessage("未記入の項目があります");
			result = ERROR;
		}
		return result;
	}
	public String getUser_id(){
		return user_id;
	}
	public void setUser_id(String user_id){
		this.user_id = user_id;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
	public String getErrorMessage(){
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage){
		this.errorMessage = errorMessage;
	}
}
