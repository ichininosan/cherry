
package com.internousdev.cherry.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordConfirmAction extends ActionSupport implements SessionAware {

	private String loginUserId;

	private String loginPassword;

	private String loginPasswordc;

	public Map<String,Object> session;

	private String errorMassage;

	public String execute() {

		String result = SUCCESS;
		boolean a = loginUserId.equals("");
		boolean b = loginPassword.equals("");
		boolean c = loginPasswordc.equals("");

		if(!a && !b && !c) {
			session.put("loginUserId", loginUserId);
			session.put("loginPassword", loginPassword);
			session.put("loginPasswordc", loginPasswordc);
		}else if(a && b && c){
			setErrorMassage("IDを入力してください。");
			result = ERROR;
		}else

		return result;
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

	public String getLoginPasswordc() {
		return loginPasswordc;
	}

	public void setLoginPasswordc(String loginPasswordc) {
		this.loginPasswordc = loginPasswordc;
	}


	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getErrorMassage() {
		return errorMassage;
	}

	public void setErrorMassage(String errorMassage) {
		this.errorMassage = errorMassage;
	}

}
