package com.internousdev.cherry.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.cherry.dao.UserInfoDAO;
import com.internousdev.cherry.util.ErrorMessageConstants;
import com.internousdev.cherry.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class CheckUserInfoAction extends ActionSupport implements ErrorMessageConstants {

	private String family_name;
	private String first_name;
	private String family_name_kana;
	private String first_name_kana;

	//0:男性、1:女性

	private String sex;
	private String email;
	private String  user_id;
	private String password;
	private ArrayList<String> errorMessageList = new ArrayList<>();
	public String execute() throws SQLException {
		String result = SUCCESS;
		UserInfoDAO dao = new UserInfoDAO();



		InputChecker i = new InputChecker();
		if (!i.familyNameChk(family_name).equals("OK")) {
			errorMessageList.add(i.familyNameChk(family_name));
			result = ERROR;
		}

		if (!i.firstNameChk(first_name).equals("OK")) {
			errorMessageList.add(i.firstNameChk(first_name));
			result = ERROR;
		}

		if (!i.familyNameKanaChk(family_name_kana).equals("OK")) {
			errorMessageList.add(i.familyNameKanaChk(family_name_kana));
			result = ERROR;
		}

		if (!i.firstNameKanaChk(first_name_kana).equals("OK")) {
			errorMessageList.add(i.firstNameKanaChk(first_name_kana));
			result = ERROR;
		}

		if(dao.existsUserId(user_id)) {
			errorMessageList.add("入力されたIDは既に存在します。");
			result = ERROR;
		}else if (!i.userIdChk(user_id).equals("OK")) {
			errorMessageList.add(i.userIdChk(user_id));
			result = ERROR;
		}

		if (!i.passwordChk(password).equals("OK")) {
			errorMessageList.add(i.passwordChk(password));
			result = ERROR;
		}

		if (!i.emailChk(email).equals("OK")) {
			errorMessageList.add(i.emailChk(email));
			result = ERROR;
		}

		if (!(sex.equals("0") || sex.equals("1"))) {
			errorMessageList.add("性別の値が不正です");
			result = ERROR;
		}

		return result;
	}


	public String getFamilyName() {
		return family_name;
	}

	public void setFamilyName(String family_name) {
		this.family_name = family_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
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

	public void setFirst_name_kana(String first_name_kana) {
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

	public ArrayList<String> getErrorMessageList() {
		return errorMessageList;
	}

	public void setErrMsgList(ArrayList<String> errorMessageList) {
		this.errorMessageList = errorMessageList;
	}
}