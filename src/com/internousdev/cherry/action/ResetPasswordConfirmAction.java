
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
		if(loginUserId.matches("{1,8}")){
			return SUCCESS;
		}else{
			System.out.println("ログインIDは1文字以上8文字以下で入力してください。");
		}
		if(loginPassword.matches("{1,16}")){
			return SUCCESS;
		}else{
			System.out.println("パスワードは1文字以上16文字以下で入力してください。");
		}
		if(loginPasswordc.matches("{1,16}")){
			return SUCCESS;
		}else{
			System.out.println("再確認パスワードは1文字以上16文字以下で入力してください。");
		}

		/**
		 * 入力文字種違い
		 */
		if(loginUserId.matches("^[0-9a-zA-Z]+$")){
			return SUCCESS;
		}else{
			System.out.println("ログインIDは半角英数字で入力してください。");
		}
		if(loginPassword.matches("^[0-9a-zA-Z]+$")){
			return SUCCESS;
		}else{
			System.out.println("パスワードは半角英数字で入力してください。");
		}
		if(loginPasswordc.matches("^[0-9a-zA-Z]+$")){
			return SUCCESS;
		}else{
			System.out.println("再確認パスワードは半角英数字で入力してください。");
		}

		/**
		 * パスワード間違い
		 */
		if(loginPassword != loginPasswordc){
			System.out.println("入力されたパスワードが異なります。");
		}

		result = ERROR;
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
