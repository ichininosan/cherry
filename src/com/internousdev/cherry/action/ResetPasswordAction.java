package com.internousdev.cherry.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cherry.dao.ResetPasswordDAO;
import com.internousdev.cherry.dto.ResetPasswordDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordAction extends ActionSupport implements SessionAware{
	private Map<String, Object> session;
	private String userId;

	public String execute(){
		//DAO,DTOのインスタンス作成
		ResetPasswordDAO dao = new ResetPasswordDAO();
		ResetPasswordDTO dto = new ResetPasswordDTO();
		session.put("userId",userId);
		return SUCCESS;
	}

	//ゲッター、セッター
	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}





	}
