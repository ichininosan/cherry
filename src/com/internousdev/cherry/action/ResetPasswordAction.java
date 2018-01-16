package com.internousdev.cherry.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cherry.dao.LoginDAO;
import com.internousdev.cherry.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordAction extends ActionSupport implements SessionAware{
	private Map<String, Object> session;
	private String userId;

	public String execute() throws SQLException{

		//DAO,DTOのインスタンス作成
		LoginDAO dao = new LoginDAO();
		UserInfoDTO userInfoDTO = new UserInfoDTO();

		//Loginされているかチェック
		dao.login(userInfoDTO);

		//userIdをDBから探す
		session.put("userId", dao.existsUserId(userId));
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
