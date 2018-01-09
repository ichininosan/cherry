package com.internousdev.cherry.action;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cherry.dao.Product_InfoDAO;
import com.internousdev.cherry.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductAction extends ActionSupport implements SessionAware{


	private String result;
	private Product_InfoDAO dao = new Product_InfoDAO();

	public String execute() {

		result = ERROR;

		proList = dao.proList();

		session.put("proList", proList);

		if(((LoginDTO) session.get("loginUser")).getLoginFlg()) {
			result = SUCCESS;
		}

		return result;
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

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
