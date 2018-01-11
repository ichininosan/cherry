package com.internousdev.cherry.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cherry.dao.CartInfoDAO;
import com.internousdev.cherry.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class PutProductIntoCartAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	private ArrayList<CartInfoDTO> cartList = new ArrayList<>();
	private boolean duplicationFlg;
	private int productId;
	private int productCount;
	private int totalPrice = 0;

	public String execute() throws SQLException{
		CartInfoDTO dto = new CartInfoDTO();
		CartInfoDAO dao = new CartInfoDAO();

		dto.setProductId(productId);
		dto.setProductCount(productCount);

		if (session.containsKey("loginFlg") && (boolean) session.get("loginFlg")) {
			dto.setUserId(session.get("userId").toString());
			if (duplicationFlg) {
				dao.updateUsersCount(dto);
			} else {
				dao.putProductIntoCart(dto);
			}
			for (CartInfoDTO cartInfoDTO: dao.showUserCartList(session.get("userId").toString())) {
				cartList.add(cartInfoDTO);
			}
		} else {
			dto.setTempUserId(session.get("userId").toString());
			if (duplicationFlg) {
				dao.updateTempUsersCount(dto);
			} else {
				dao.putProductIntoCartOfGuestUser(dto);
			}
			for (CartInfoDTO cartInfoDTO: dao.showTempUserCartList(session.get("userId").toString())) {
				cartList.add(cartInfoDTO);
			}
		}

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
	 * @return productId
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * @param productId セットする product_id
	 */
	public void setProductId(int productId) {
		this.productId = productId;
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
	 * @return duplicationFlg
	 */
	public boolean isDuplicationFlg() {
		return duplicationFlg;
	}


	/**
	 * @param duplicationFlg セットする duplicationFlg
	 */
	public void setDuplicationFlg(boolean duplicationFlg) {
		this.duplicationFlg = duplicationFlg;
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
		}
		return totalPrice;
	}


	public int getProductCount() {
		return productCount;
	}


	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}


}
