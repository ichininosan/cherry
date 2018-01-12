package com.internousdev.cherry.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cherry.dao.CartInfoDAO;
import com.internousdev.cherry.dao.LoginDAO;
import com.internousdev.cherry.dto.CartInfoDTO;
import com.internousdev.cherry.dto.UserInfoDTO;
import com.internousdev.cherry.util.ErrorMessageConstants;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware, ErrorMessageConstants {


	private String userId;

	private String password;

	private boolean saveLogin;

	private Map<Integer, String> categoryMap = new HashMap<>();

	private Map<String, Object> session;

	private ArrayList<String> errorMessageList = new ArrayList<>();

	public String execute() throws SQLException {
		String result = ERROR;
		UserInfoDTO userInfoDTO = new UserInfoDTO();
		CartInfoDAO cartInfoDAO = new CartInfoDAO();
		int updateCount = 0;
		LoginDAO loginDAO = new LoginDAO();



		if (userId.equals("")) {
			errorMessageList.add("ユーザーIDを入力してください。");

		} else if (userId.length() < 1 || userId.length() > 16) {
			errorMessageList.add("ユーザーIDは1文字以上16文字以下で入力してください。");

		} else if (!userId.matches("^[a-zA-Z0-9]+$")) {
			errorMessageList.add("ユーザーIDは半角英数字で入力してください");

		}

		if (password.equals("")) {
			errorMessageList.add("パスワードを入力してください。");

		} else if (password.length() < 1 || password.length() > 8) {
			errorMessageList.add("パスワードは1文字以上8文字以下で入力してください");

		} else if (!password.matches("^[a-zA-Z0-9]+$")) {
			errorMessageList.add("パスワードは半角英数字で入力してください");

		}

		if (saveLogin) {
			session.put("saveId", userId);

		} else {
			session.remove("saveId");
		}

		if (!userId.equals("") && !password.equals("")) {
			if (!loginDAO.existsUserId(userId)) {
				errorMessageList.add("IDが正しくありません。");
				result = ERROR;
			} else {
				userInfoDTO = loginDAO.select(userId, password);

				if (userId.equals(userInfoDTO.getUserId()) && password.equals(userInfoDTO.getPassword())) {
					loginDAO.login(userInfoDTO);

					for (CartInfoDTO cartInfoDTO : cartInfoDAO.showTempUserCartList(session.get("userId").toString())) {
						if (cartInfoDAO.isAlreadyIntoCart(userInfoDTO.getUserId(), cartInfoDTO.getProductId())) {
							cartInfoDAO.deleteProductFromTempUserCart(session.get("userId").toString(),
									cartInfoDTO.getProductId());
						}
					}
					updateCount = cartInfoDAO.integrateCart(session.get("userId").toString(), userInfoDTO.getUserId());
					System.out.println(updateCount + "件統合しました。");
					result = SUCCESS;

					session.put("userId", userInfoDTO.getUserId());
					session.put("loginFlg", true);
				} else {
					errorMessageList.add("入力されたパスワードが異なります。");
					result = ERROR;
				}
			}
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


	public boolean isSaveLogin() {
		return saveLogin;
	}


	public void setSaveLogin(boolean saveLogin) {
		this.saveLogin = saveLogin;
	}


	public Map<Integer, String> getCategoryMap() {
		return categoryMap;
	}


	public void setCategoryMap(Map<Integer, String> categoryMap) {
		this.categoryMap = categoryMap;
	}


	public Map<String, Object> getSession() {
		return session;
	}


	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	public ArrayList<String> getErrorMessageList() {
		return errorMessageList;
	}


	public void setErrorMessageList(ArrayList<String> errorMessageList) {
		this.errorMessageList = errorMessageList;
	}

}