package com.internousdev.cherry.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cherry.dao.LoginDAO;
import com.internousdev.cherry.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport implements SessionAware{

	private String user_id;
	private String password;

	private String result;
	public Map<String, Object> session;
	private String errorMessage;
	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();
//	private BuyItemDAO buyItemDAO = new BuyItemDAO();
	public String execute() {

		result = ERROR;

		loginDTO = loginDAO.getLoginUserInfo(user_id, password);

		session.put("loginUser", loginDTO);

		if(((LoginDTO) session.get("loginUser")).getLoginFlg()) {
			result = SUCCESS;


//			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();
//			session.put("user_id",	loginDTO.getUser_id());
//			session.put("id", buyItemDTO.getId());
//			session.put("product_name", buyItemDTO.getItemName());
//			session.put("price", buyItemDTO.getItemPrice());
//
//			return result;

		}else{
			if(user_id.equals("")){
				setErrorMessage("ユーザーIDを入力して下さい");
		}else{
			if(password.equals("")){
				setErrorMessage("パスワードを入力して下さい");
		}else{


			if (user_id.length() < 1 || user_id.length() > 8) {
				setErrorMessage("ログインIDは1文字以上8文字以内で入力して下さい");
		}else{
			if (password.length() < 1 || password.length() > 16) {
				setErrorMessage("パスワードは1文字以上16文字以内で入力して下さい");
		}else{


			if (!(user_id.matches("[0-9a-zA-Z]+"))) {
				setErrorMessage("ログインIDは半角英数字で入力して下さい");
		}else{
			if (!(password.matches("[0-9a-zA-Z]+"))) {
				setErrorMessage("パスワードは半角英数字で入力して下さい");
		}else{


			}




		}}}}}}




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

	public String getErrorMessage(){
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage){
		this.errorMessage = errorMessage;
	}
}
