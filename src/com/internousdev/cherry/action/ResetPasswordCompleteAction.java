package com.internousdev.cherry.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cherry.dao.ResetPasswordDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordCompleteAction  extends ActionSupport implements SessionAware{

	private String loginUserId;

	private String loginPassword;

	public Map<String,Object> session;

	private ResetPasswordDAO resetPasswordDAO = new ResetPasswordDAO();

	public String execute() throws SQLException {

		resetPasswordDAO.updatePassword(session.get("userId").toString(),
				session.get("password").toString());

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
