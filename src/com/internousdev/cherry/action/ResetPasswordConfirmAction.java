
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
	private String confirmpass;
	private String confirmpass1;
	private String confirmpass2;
	private String s;


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


	//エラーメッセージ表示
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
		//パスワードが4文字以上のとき、最初の2文字のみ表示して、3文字以降を*で表示する
		if(password.length() > 3){
			confirmpass = password.substring(0,2);
			confirmpass1 = password.substring(2).replaceAll("^[0-9a-zA-Z]+$","*");
			s = confirmpass + confirmpass1;
		//パスワードが3文字以下のとき、*で表示する
		}else{
			s = password.replaceAll("^[0-9a-zA-Z]+$","*");
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


	public String getConfirmpass() {
		return confirmpass;
	}

	public void setConfirmpass(String confirmpass) {
		this.confirmpass = confirmpass;
	}

	public String getConfirmpass1() {
		return confirmpass1;
	}


	public void setConfirmpass1(String confirmpass1) {
		this.confirmpass1 = confirmpass1;
	}

	public String getConfirmpass2() {
		return confirmpass2;
	}


	public void setConfirmpass2(String confirmpass2) {
		this.confirmpass2 = confirmpass2;
	}


	public String getS() {
		return s;
	}


	public void setS(String s) {
		this.s = s;
	}


	public ArrayList<String> getErrMsgList() {
		return errMsgList;
	}

	public void setErrMsgList(ArrayList<String> errMsgList) {
		this.errMsgList = errMsgList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
