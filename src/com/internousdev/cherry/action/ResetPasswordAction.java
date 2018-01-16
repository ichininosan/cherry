package com.internousdev.cherry.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cherry.dao.LoginDAO;
import com.internousdev.cherry.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordAction extends ActionSupport implements SessionAware{
	private Map<String, Object> session;
	private String userId;
	private boolean saveLogin;

	public String execute() throws SQLException{

/*		//DAO,DTOのインスタンス作成
		LoginDAO dao = new LoginDAO();
		UserInfoDTO userInfoDTO = new UserInfoDTO();



		//IDの入力省略のチェックボックスにチェックされているか
		if ((boolean) session.get("savaId")) {
			//userIdをDBから探す
			session.put("userId", dao.existsUserId(userId));
			return SUCCESS;
		}else{
			return ERROR;
		}*/
		//DAO,DTOのインスタンス作成
				LoginDAO dao = new LoginDAO();
				UserInfoDTO userInfoDTO = new UserInfoDTO();
				
/*				if((boolean) session.get("loginFlg")){
					
				}

				//Loginされているかチェック
				dao.login(userInfoDTO);

				//userIdをDBから探す
				session.put("userId", dao.existsUserId(userId));*/
				return SUCCESS;
			}


	//ゲッター、セッター
	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean isSaveLogin() {
		return saveLogin;
	}

	public void setSaveLogin(boolean saveLogin) {
		this.saveLogin = saveLogin;
	}





	}
