package com.internousdev.cherry.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cherry.dao.ResetPasswordDAO;
import com.internousdev.cherry.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordAction extends ActionSupport implements SessionAware{

	public String execute(){
		ResetPasswordDAO dao = new ResetPasswordDAO();
		LoginDTO dto = new LoginDTO();

			dao.getLoginId(dto.getUser_id());
			return SUCCESS;
		}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO 自動生成されたメソッド・スタブ

	}

	}
