package com.internousdev.cherry.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cherry.dao.CartInfoDAO;
import com.internousdev.cherry.dto.CartInfoDTO;
import com.internousdev.cherry.util.ErrorMessageConstants;
import com.opensymphony.xwork2.ActionSupport;

public class GoCartAction extends ActionSupport implements SessionAware,ErrorMessageConstants{

	Map<String, Object> session;
	ArrayList<CartInfoDTO> cartList = new ArrayList<>();
	int totalPrice;

	public String execute() throws SQLException{

		CartInfoDAO dao = new CartInfoDAO();

		//暫定でセッション値セット//
		//session.put("loginFlg",true);
		//session.put("userId", "a");
		//session.put("tempUserId", "a");

		//ログインユーザーのカート情報を引き出す
		if((boolean) session.get("loginFlg")){
			for(CartInfoDTO dto: dao.showUserCartList(session.get("userId").toString())){
				cartList.add(dto);
				System.out.println("ログインユーザー");
			}
		//非ログインユーザーのカート情報を引き出す
		}else{
			for(CartInfoDTO dto: dao.showTempUserCartList(session.get("tempUserId").toString())){
				cartList.add(dto);
			}
		}
		//合計金額の計算
		totalPrice = calcTotalPrice(cartList);

		return SUCCESS;
	}

	/**
	 * @return session
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * @param session セットする session
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * @return cartList
	 */
	public ArrayList<CartInfoDTO> getCartList() {
		return cartList;
	}

	/**
	 * @param cartList セットする cartList
	 */
	public void setCartList(ArrayList<CartInfoDTO> cartList) {
		this.cartList = cartList;
	}


	/**
	 * @return totalPrice
	 */
	public int getTotalPrice() {
		return totalPrice;
	}


	/**
	 * @param totalPrice セットする totalPrice
	 */
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}


	/**
	 * 合計金額を計算するメソッド
	 */
	public int calcTotalPrice(ArrayList<CartInfoDTO> cartList) {
		int totalPrice = 0;
		for(CartInfoDTO dto: cartList) {
			totalPrice += dto.getPrice() * dto.getProductCount();
			System.out.println("合計" + totalPrice + "円");
		}
		return totalPrice;
	}





}

















