package com.internousdev.cherry.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cherry.dao.MyPageDAO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware{

	/*
	 * 画面遷移時に渡された情報群
	 */
	public Map<String, Object> session;

	public String execute(){

		try{
			MyPageDAO dao =new MyPageDAO();

			return SUCCESS;
		}catch (SQLException e){
			e.printStackTrace();
			return ERROR;
		}
	}
	/**
	 * @return session
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * @param session セットする session
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * @return dto
	 */

	 /** @param dto セットする dto
	 */


}
