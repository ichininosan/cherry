package com.internousdev.cherry.action;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cherry.dao.CartInfoDAO;
import com.internousdev.cherry.dao.Product_InfoDAO;
import com.internousdev.cherry.dto.ProductDTO;
import com.opensymphony.xwork2.ActionSupport;


public class ProDetailAction extends ActionSupport implements SessionAware{

	//商品ID(Primary Keyのほう)
	private String id;

	//商品ID
	private int productId;

	//セッション
	private Map<String,Object> session;

	//商品一覧
	ProductDTO pro_detail = new ProductDTO();

	//購入個数
	private ArrayList<Integer> count = new ArrayList<>();

	//商品重複フラグ
	private boolean duplicationFlg;

	public String execute() throws SQLException{
		Product_InfoDAO dao=new Product_InfoDAO();
		int pro_id = Integer.parseInt(id.toString());

		try {
			pro_detail = dao.pro_detail(pro_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.put("pro_detail", pro_detail);

		//暫定でセッション値セット//
		session.put("loginFlg",true);
		session.put("userId", "a");

		//ここから、目標の商品がすでにカートに入っているかどうか確認
		CartInfoDAO cartInfoDAO = new CartInfoDAO();
		if((boolean)session.get("loginFlg")) {
			duplicationFlg = cartInfoDAO.isAlreadyIntoCart(session.get("userId").toString(), productId);
		} else {
			duplicationFlg = cartInfoDAO.isAlreadyIntoTempCart(session.get("userId").toString(), productId);
		}

		//ここから、購入個数を在庫に応じて変えるよう記述
		for(int i = 1; i <= 5; i++) {
			if (i > pro_detail.getStock()) {
				break;
			}
			count.add(i);
		}


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

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public ArrayList<Integer> getCount() {
		return count;
	}

	public void setCount(ArrayList<Integer> count) {
		this.count = count;
	}

	public boolean isDuplicationFlg() {
		return duplicationFlg;
	}

	public void setDuplicationFlg(boolean duplicationFlg) {
		this.duplicationFlg = duplicationFlg;
	}



}
