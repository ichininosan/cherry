package com.internousdev.cherry.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cherry.dao.ResetPasswordCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordCompleteAction  extends ActionSupport implements SessionAware{

	private String loginUserId;

	private String loginPassword;

	public Map<String,Object> session;

	private ResetPasswordCompleteDAO resetPasswordCompleteDAO = new ResetPasswordCompleteDAO();

	public String execute() throws SQLException {

		resetPasswordCompleteDAO.resetPassword(session.get("loginUserId").toString(),
				session.get("loginPassword").toString());

		String result = SUCCESS;

		return result ;
	}


	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}





	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
