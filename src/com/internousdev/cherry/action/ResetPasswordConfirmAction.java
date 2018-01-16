
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

	//パスワードの先頭2文字
	private String confirmpass;
	//パスワードの3文字目以降
	private String confirmpass3;
	//確認画面で表示するパスワード
	private String s;

	private ArrayList<String> errMsgList = new ArrayList<>();
	public Map<String,Object> session;


	//エラーメッセージ表示
	public String execute(){
		String result = SUCCESS;
		//インプットチェッカー利用して条件判定とエラーメッセージ表示
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
			confirmpass3 = password.substring(2).replaceAll("^[0-9a-zA-Z]+$","*");
			s = confirmpass + confirmpass3;
		//パスワードが3文字以下のとき、*で表示する
		}else{
			s = password.replaceAll("^[0-9a-zA-Z]+$","*");
		}
		return result;
	}


	//ゲッター、セッター
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

	public String getConfirmpass3() {
		return confirmpass3;
	}


	public void setConfirmpass3(String confirmpass1) {
		this.confirmpass3 = confirmpass1;
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
