package com.internousdev.cherry.action;


import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cherry.dao.Product_InfoDAO;
import com.internousdev.cherry.dto.ProductDTO;
import com.opensymphony.xwork2.ActionSupport;


public class ProDetailAction extends ActionSupport implements SessionAware{

	// 商品ID
	private String id;

	//セッション
	private Map<String,Object> session;

	//商品一覧
	ProductDTO pro_detail = new ProductDTO();

	//購入個数
	private ArrayList<Integer> count = new ArrayList<>();

	//商品重複フラグ
	private boolean duplicationFlg;

	public String execute(){
		Product_InfoDAO dao=new Product_InfoDAO();
		int pro_id = Integer.parseInt(id.toString());

		try {
			pro_detail = dao.pro_detail(pro_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.put("pro_detail", pro_detail);

		return SUCCESS;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public ProductDTO getPro_detail() {
		return pro_detail;
	}

	public void setPro_detail(ProductDTO pro_detail) {
		this.pro_detail = pro_detail;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}



}
