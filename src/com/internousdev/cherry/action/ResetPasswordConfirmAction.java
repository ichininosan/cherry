
package com.internousdev.cherry.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cherry.util.ErrorMessageConstants;
import com.internousdev.cherry.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordConfirmAction extends ActionSupport implements SessionAware,ErrorMessageConstants {

	private String userId;
	private String password;
	private String passwordc;
	private ArrayList<String> errMsgList = new ArrayList<>();

	public Map<String,Object> session;

	public String confirmId1 = userId.substring(0);
	public String confirmId2 = userId.substring(1);
	public String confirmId = confirmId1 + confirmId2.replaceAll("^[0-9a-zA-Z]+$","*");

	public String confirmPass1 = password.substring(0);
	public String confirmPass2 = password.substring(1);
	public String confirmPass = confirmPass1 + confirmPass2.replaceAll("^[0-9a-zA-Z]+$","*");


	public String execute(){
		String result = SUCCESS;

		InputChecker i = new InputChecker();
		if(!i.userIdChk(userId).equals("OK")){
			errMsgList.add(i.userIdChk(userId));
			result = ERROR;
		}
		if(!i.passwordChk(password).equals("OK")){
			errMsgList.add(i.passwordChk(password));
			result = ERROR;
		}
		if(!i.passwordcChk(passwordc,password).equals("OK")){
			errMsgList.add(i.passwordcChk(passwordc,password));
			result = ERROR;
		}
		return result;
	}


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordc() {
		return passwordc;
	}

	public void setPasswordc(String passwordc) {
		this.passwordc = passwordc;
	}


	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
