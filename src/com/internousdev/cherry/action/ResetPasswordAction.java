package com.internousdev.cherry.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cherry.dao.ResetPasswordDAO;
import com.internousdev.cherry.dto.ResetPasswordDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordAction extends ActionSupport implements SessionAware{
	Map<String, Object> session;

	public String execute(){
		ResetPasswordDAO dao = new ResetPasswordDAO();
		ResetPasswordDTO dto = new ResetPasswordDTO();
		//暫定でセッション値セット//
				session.put("loginFlg",true);
				session.put("userId", "a");

		//ログインユーザーのカート情報を引き出す
				if(session.containsKey("loginFlg") && (boolean) session.get("loginFlg")){
					dao.getUserId("user_id");
					dto.getuserId();
					}


			return SUCCESS;
		}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO 自動生成されたメソッド・スタブ

	}

	}
