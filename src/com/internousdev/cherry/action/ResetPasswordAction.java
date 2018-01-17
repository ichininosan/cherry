package com.internousdev.cherry.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cherry.dao.LoginDAO;
import com.internousdev.cherry.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordAction extends ActionSupport implements SessionAware{
	public Map<String, Object> session;
	private String userId;
	private String password;
	private boolean saveLogin;
	public String result;

	LoginDAO loginDAO = new LoginDAO();
	UserInfoDTO userInfoDTO = new UserInfoDTO();

	public String execute() throws SQLException{
		return SUCCESS;
/**
		//ログイン画面で入力されたuserIdをsessioに保管
		if ((!userId.equals("")) && loginDAO.existsUserId(userId)) {

			//会員情報DTOにuserIdとパスワードを設置
			userInfoDTO = loginDAO.select(userId,password);

			//sessionにuserIdを保管、チェックボックスしてるか
			session.put("userId", userInfoDTO.getUserId());
			session.put("saveLogin", true);
		}

		//DAOのインスタンス作成
			ResetPasswordDAO dao = new ResetPasswordDAO();

		//IDチェックボックスかつID入力時→再設定画面でuserID表示
			if((!(userId.equals("")))&&saveLogin){
			//userIdをDBから探す
			session.put("userId", dao.getUserId(userId));
			return result;
		}else{
			return ERROR;
		}
*/
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isSaveLogin() {
		return saveLogin;
	}

	public void setSaveLogin(boolean saveLogin) {
		this.saveLogin = saveLogin;
	}





	}
