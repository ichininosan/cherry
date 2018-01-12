package com.internousdev.cherry.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cherry.dao.UserInfoDAO;
import com.internousdev.cherry.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterUserInfoAction extends ActionSupport implements SessionAware {

	Map<String, Object> session;

	private String  user_id;

	private String password;

	private String family_name;

	private String first_name;

	private String family_name_kana;

	private String first_name_kana;

	/**
	 * 0:男性、1:女性
	 */
	private String sex;

	private String email;

	public String execute() throws SQLException {

		UserInfoDAO dao = new UserInfoDAO();
		UserInfoDTO dto = new UserInfoDTO();
		dto.setUserName(family_name, first_name, family_name_kana, first_name_kana);
		if(sex.equals("0")) {
			dto.setSex(false);
		} else if (sex.equalsIgnoreCase("1")) {
			dto.setSex(true);
		}
		dto.setEmail(email);
		dto.setUserId(user_id);
		dto.setPassword(password);

		if (dao.registerUser(dto)) {
			session.put("user_id", user_id);
			session.put("logined", true);

			return SUCCESS;

		} else {
			return ERROR;
		}
	}




	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getFamily_name() {
		return family_name;
	}

	public void setFamily_name(String family_name) {
		this.family_name = family_name;
	}

	public String getFirstName() {
		return first_name;
	}

	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}

	public String getFamily_name_kana() {
		return family_name_kana;
	}

	public void setFamily_name_kana(String family_name_kana) {
		this.family_name_kana = family_name_kana;
	}

	public String getFirst_name_kana() {
		return first_name_kana;
	}

	public void setFrist_name_kana(String first_name_kana) {
		this.first_name_kana = first_name_kana;
	}

	public String isSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
}