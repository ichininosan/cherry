
package com.internousdev.cherry.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cherry.util.ErrorMessageConstants;
import com.internousdev.cherry.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordConfirmAction extends ActionSupport implements SessionAware,ErrorMessageConstants {

	private String user_id;
	private String password;
	private String passwordc;
	private ArrayList<String> errMsgList = new ArrayList<>();

	public Map<String,Object> session;




/**
 * public char confirmId1 = user_id.charAt(0);
	public String confirmId2 = user_id.substring(1);
	public String confirmId = confirmId1 + confirmId2.replaceAll("^[0-9a-zA-Z]+$","*");

	public char confirmPass1 = password.charAt(0);
	public String confirmPass2 = password.substring(1);
	public String confirmPass = confirmPass1 + confirmPass2.replaceAll("^[0-9a-zA-Z]+$","*");
 */


	public String execute(){
		String result = SUCCESS;

		InputChecker i = new InputChecker();
		if(!i.userIdChk(user_id).equals("OK")){
			errMsgList.add(i.userIdChk(user_id));
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
		return user_id;
	}

	public void setUserId(String userId) {
		this.user_id = userId;
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

	public ArrayList<String> getErrMsgList() {
		return errMsgList;
	}

	public void setErrMsgList(ArrayList<String> errMsgList) {
		this.errMsgList = errMsgList;
	}



	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
