package com.internousdev.cherry.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cherry.dao.ResetPasswordDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordCompleteAction  extends ActionSupport implements SessionAware{

	private String user_id;

	private String password;

	public Map<String,Object> session;

	private ResetPasswordDAO resetPasswordDAO = new ResetPasswordDAO();

	public String execute() throws SQLException {

		resetPasswordDAO.updatePassword(session.get("user_id").toString(),
				session.get("password").toString());

		String result = SUCCESS;

		return result ;
	}


	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
}
