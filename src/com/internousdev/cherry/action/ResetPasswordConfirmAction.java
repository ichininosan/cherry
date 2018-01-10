
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

	public String confirmId1 = loginUserId.substring(0);
	public String confirmId2 = loginUserId.substring(1,8);
	public String confirmId = confirmId1 + confirmId2;

	public String confirmPass1 = loginPassword.substring(0);
	public String confirmPass2 = loginPassword.substring(1,16);
	public String confirmPass = confirmPass1 + confirmPass2;


	public String execute(){


		if(!(loginUserId.equals("")) && !(loginPassword.equals("")) && !(loginPasswordc.equals(""))) {
			session.put("loginUserId", loginUserId);
			session.put("loginPassword", loginPassword);
			return SUCCESS;
		}

		/**
		 * 未入力
		 */
		if(!(loginUserId.equals(""))){
			setErrorMassage("ログインIDを入力してください。");
		}
		if(!(loginPassword.equals(""))){
			setErrorMassage("パスワードを入力してください。");
		}
		if(!(loginPasswordc.equals(""))){
			setErrorMassage("再確認パスワードを入力してください。");
		}

		/**
		 * 桁数
		 */
		if(!(loginUserId.matches("{1,8}"))){
			setErrorMassage("ログインIDは1文字以上8文字以下で入力してください。");
		}
		if(!(loginPassword.matches("{1,16}"))){
			setErrorMassage("パスワードは1文字以上16文字以下で入力してください。");
		}
		if(!(loginPasswordc.matches("{1,16}"))){
			setErrorMassage("再確認パスワードは1文字以上16文字以下で入力してください。");
		}

		/**
		 * 入力文字種違い
		 */
		if(!(loginUserId.matches("^[0-9a-zA-Z]+$"))){
			setErrorMassage("ログインIDは半角英数字で入力してください。");
		}
		if(!(loginPassword.matches("^[0-9a-zA-Z]+$"))){
			setErrorMassage("パスワードは半角英数字で入力してください。");
		}
		if(!(loginPasswordc.matches("^[0-9a-zA-Z]+$"))){
			setErrorMassage("再確認パスワードは半角英数字で入力してください。");
		}

		/**
		 * パスワード間違い
		 */
		if(loginPassword != loginPasswordc){
			setErrorMassage("入力されたパスワードが異なります。");
		}

		return ERROR;
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
