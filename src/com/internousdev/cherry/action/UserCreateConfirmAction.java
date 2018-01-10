package com.internousdev.cherry.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware{
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
	private String errorMessage;

	public String execute(){
		result = SUCCESS;

		if(!(user_id.equals("")) && !(password.equals("")) && !(family_name.equals("")) && !(first_name.equals("")) && !(family_name_kana.equals("")) && !(first_name_kana.equals("")) && !(sex.equals("")) && !(email.equals(""))){
			session.put("user_id", user_id);
			session.put("password", password);
			session.put("family_name", family_name);
			session.put("first_name", first_name);
			session.put("family_name_kana", family_name_kana);
			session.put("first_name_kana", first_name_kana);
			session.put("sex", sex);
			session.put("email", email);

		}else {

			if(user_id.equals("")){
				setErrorMessage("ユーザーIDを入力して下さい");
		}else{
			if(password.equals("")){
				setErrorMessage("パスワードを入力して下さい");
		}else{
			if(family_name.equals("")){
				setErrorMessage("姓を入力して下さい");
		}else{
			if(first_name.equals("")){
				setErrorMessage("名を入力して下さい");
		}else{
			if(family_name_kana.equals("")){
				setErrorMessage("姓ふりがなを入力して下さい");
		}else{
			if(first_name_kana.equals("")){
				setErrorMessage("名ふりがなを入力して下さい");
		}else{
			if(sex .equals("")){
				setErrorMessage("性別を選択して下さい");
		}else{
			if(email.equals("")){
				setErrorMessage("メールアドレスを入力して下さい");
		}else{


			if (user_id.length() < 1 || user_id.length() > 8) {
				setErrorMessage("ログインIDは1文字以上8文字以内で入力して下さい");
		}else{
			if (password.length() < 1 || password.length() > 16) {
				setErrorMessage("パスワードは1文字以上16文字以内で入力して下さい");
		}else{
			if (family_name.length() < 1 || family_name.length() > 16) {
					setErrorMessage("姓は1文字以上16文字以内で入力して下さい");
		}else{
			if (first_name.length() < 1 || first_name.length() > 16) {
				setErrorMessage("名は1文字以上16文字以内で入力して下さい");
		}else{
			if (family_name_kana.length() < 1 || family_name.length() > 16) {
				setErrorMessage("姓ふりがなは1文字以上16文字以内で入力して下さい");
		}else{
			if (family_name_kana.length() < 1 || family_name.length() > 16) {
				setErrorMessage("名ふりがなは1文字以上16文字以内で入力して下さい");
		}else{
			if (family_name.length() < 14 || family_name.length() > 32) {
				setErrorMessage("メールアドレスは14文字以上32文字以内で入力して下さい");
		}else{




			if (!(user_id.matches("[0-9a-zA-Z]+"))) {
				setErrorMessage("ログインIDは半角英数字で入力して下さい");
		}else{
			if (!(password.matches("[0-9a-zA-Z]+"))) {
				setErrorMessage("パスワードは半角英数字で入力して下さい");
		}else{
			if (!(family_name.matches("\\p{InCjkUnifiedIdeographs}" + "^[\\u3040-\\u309F]+$" + ".*[^A-Za-z].*" ))) {
				setErrorMessage("姓は漢字かひらがな、または半角英語で入力して下さい");
		}else{
			if (!(first_name.matches("\\p{InCjkUnifiedIdeographs}" + "^[\\u3040-\\u309F]+$" + ".*[^A-Za-z].*" ))) {
				setErrorMessage("名は漢字かひらがな、または半角英語で入力して下さい");
		}else{
			if (!(family_name_kana.matches("^[\\u3040-\\u309F]+$"))) {
				setErrorMessage("姓ふりがなはひらがなで入力して下さい");
		}else{
			if (!(family_name_kana.matches("^[\\u3040-\\u309F]+$"))) {
				setErrorMessage("名ふりがなはひらがなで入力して下さい");
		}else{
			if (!(email.matches("[0-9a-zA-Z]+" + "_-@+*;:#$%&"))) {
				setErrorMessage("メールアドレスは半角英数字か半角記号で入力して下さい");
		}}}}}}}}}}}}}}}}}}}}}}




		result = ERROR;
		}

		return result;
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
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
	public String getErrorMessage(){
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage){
		this.errorMessage = errorMessage;
	}
}
