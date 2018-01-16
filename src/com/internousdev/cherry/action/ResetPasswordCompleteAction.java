package com.internousdev.cherry.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cherry.dao.ResetPasswordDAO;
import com.internousdev.cherry.dto.ResetPasswordDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordCompleteAction  extends ActionSupport implements SessionAware{

	private String userId;

	//新規パスワード
	private String password;

	public Map<String,Object> session;
	private ResetPasswordDAO DAO = new ResetPasswordDAO();
	private ResetPasswordDTO DTO = new ResetPasswordDTO();

	//実行メソッド
	public String execute() throws SQLException {

		//password=session.get("password").toString();
		//userId=session.get("userId").toString();

		//ログインIDをDBから取得
		if(DAO.getUserId(userId)){
			return SUCCESS;
		}

		//ユーザーIDを元にして新しいパスワードをDBにセット
		if(DAO.updatePassword(password,userId)){
			return SUCCESS;
		}
		return ERROR;
	}


	//ユーザーIDのゲッター、セッター
	public String getUserId() {
		return userId;
	}
	public void setUser_id(String userId) {
		this.userId = userId;
	}

	//新規パスワードのゲッター、セッター
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	//セッション
	public Map<String, Object> getSession() {
			return session;
		}
	@Override
	public void setSession(Map<String, Object> session) {
			this.session = session;
	}

	//DTOのゲッター、セッター
	public ResetPasswordDTO getDTO() {
		return DTO;
	}
	public void setDTO(ResetPasswordDTO dTO) {
		DTO = dTO;
	}
}
