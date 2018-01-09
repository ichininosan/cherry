package com.internousdev.cherry.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cherry.dao.UserCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateCompleteAction extends ActionSupport implements SessionAware {
	private String user_id;
	private String password;
	private String family_name;
	private String first_name;
	private String family_name_kana;
	private String first_name_kana;
	private String sex;
	private String email;

	public Map<String,Object> session;
	private String result;
	private UserCreateCompleteDAO userCreateCompleteDAO = new UserCreateCompleteDAO();
	private int id;

	public String execute() throws SQLException{
		userCreateCompleteDAO.createUser(session.get("user_id").toString(),
				session.get("password").toString(),
				session.get("family_name").toString(),
				session.get("first_name").toString(),
				session.get("family_name_kana").toString(),
				session.get("first_name_kana").toString(),
				session.get("sex").toString(),
				session.get("email").toString());

		result = SUCCESS;
		return result ;
	}
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}

	public String getUser_id(){
		return user_id;
	}
	public void setUser_id(String user_id){
		this.user_id = user_id;
	}

	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}

	public String getFamily_name(){
		return family_name;
	}
	public void setFamily_name(String family_name){
		this.family_name = family_name;
	}

	public String getFirst_name(){
		return first_name;
	}
	public void setFirst_name(String first_name){
		this.first_name = first_name;
	}

	public String getFamily_name_kana(){
		return family_name_kana;
	}
	public void setFamily_name_kana(String family_name_kana){
		this.family_name_kana = family_name_kana;
	}

	public String getFirst_name_kana(){
		return first_name_kana;
	}
	public void setFirst_name_kana(String first_name_kana){
		this.first_name_kana = first_name_kana;
	}

	public String Sex(){
		return sex;
	}
	public void Sex(String sex){
		this.sex = sex;
	}

	public String Email(){
		return email;
	}
	public void Email(String email){
		this.email = email;
	}




	@Override
	public void setSession(Map<String,Object>session){
		this.session = session;
	}

}
