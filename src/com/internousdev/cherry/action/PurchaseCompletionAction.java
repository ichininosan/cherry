package com.internousdev.cherry.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class PurchaseCompletionAction extends ActionSupport implements SessionAware{

	public Map<String, Object>session;

	/**
	 * カート情報取得DAO
	 */
	private DAO DAO = new DAO();

	/**
	 * カート情報格納DTO
	 */
	public ArrayList<DTO> List = new ArrayList<DTO>();




	/**
	 * 商品購入情報登録完了メソッド
	 */

	public String execute(){
		String result=SUCCESS;

		session.clear();

		return result;
	}


	@Override
	public void setSession(Map<String,Object>session){
		this.session=session;
	}




}
