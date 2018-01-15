package com.internousdev.cherry.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cherry.dao.ResetPasswordDAO;
import com.internousdev.cherry.dto.ResetPasswordDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordCompleteAction  extends ActionSupport implements SessionAware{

	private String userId;
	private String password;
	public Map<String,Object> session;

	private ResetPasswordDAO resetPasswordDAO = new ResetPasswordDAO();
	private ResetPasswordDTO resetPasswordDTO = new ResetPasswordDTO();

	public String execute() throws SQLException {

		/*
		password=session.get("password").toString();
		user_id=session.get("user_id").toString();
		/*

		 */
		/*ログインIDをDBから特定*/
		resetPasswordDAO.getUserId(userId);

		/*ユーザーIDを元にして新しいパスワードをDBにセットするメソッド*/
		if(resetPasswordDAO.updatePassword(userId,password)){
			return SUCCESS;
		}
		return ERROR;
	}


	//ゲッター、セッター
	public String getUserId() {
		return userId;
	}

	public void setUser_id(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ResetPasswordDTO getResetPasswordDTO() {
		return resetPasswordDTO;
	}

	public void setResetPasswordDTO(ResetPasswordDTO resetPasswordDTO) {
		this.resetPasswordDTO = resetPasswordDTO;
	}
}
