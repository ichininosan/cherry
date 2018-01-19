package com.internousdev.cherry.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class GoLoginAction extends ActionSupport implements SessionAware {

	/**
	 * セッション
	 */
	public Map<String, Object> session;

	public String execute() {
		if (session.containsKey("loginFlg")) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	/**
	 * @return session
	 */
	public Map<String, Object> getSession() {
		return this.session;
	}

	/**
	 * @Override
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}