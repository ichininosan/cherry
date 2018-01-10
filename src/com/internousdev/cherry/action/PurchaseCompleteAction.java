package com.internousdev.cherry.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;


public class PurchaseCompleteAction extends ActionSupport implements SessionAware{

	private ArrayList<CartInfoDTO> cartInfoDTO = new ArrayList<CartInfoDTO>();
	private  Map<String,Object> session;
	private int totalPrice = 0;
	private int count;


	/**
	 * 合計金額を計算するメソッド
	 */
		public int calcTotalPrice(ArrayList<CartInfoDTO> cartList) {
			int totalPrice = 0;
			for(CartInfoDTO cartInfoDTO: cartList) {
				totalPrice = cartInfoDTO.getPrice() * cartInfoDTO.getCount();
			}
			return totalPrice;


	/**
	 * カート情報登録メソッド
	 */
	public String execute() throws SQLException{
			String result = SUCCESS;

			CartInfoDAO cartinfoDAO = new CartInfoDAO();//カート情報取得DAO
			ArrayList<CartInfoDTO> cartInfoDTO = new ArrayList<CartInfoDTO>();//カート情報格納DTO
			PurchaseHistoryDAO purchaseHistoryDAO=new PurchaseHistoryDAO();//購入履歴取得DAO



			cartInfoDTO = cartInfoDAO.getUserCartInfo(session.get("userId").toString());//userIDに紐づいているカート情報をDTOに代入

			//商品ごとの合計金額をだし、購入履歴テーブルpriceに入れる


			purchaseHistoryDAO.purchaseHistoryInfo(session.get("userId").toString());//userIdに紐づいているカート情報を購入履歴に挿入
			cartInfoDAO.deleteUserCartInfo(session.get("userId").toString());//userIdに紐づいているカート情報を削除

			return result;

		}



		public Map<String,Object> getSession(){
			return session;
		}
		public void setSession(Map<String,Object> session){
			this.session=session;
		}

		public ArrayList<CartInfoDTO> getCartInfoDTO() {
			return cartInfoDTO;
		}



		public void setCartInfoDTO(ArrayList<CartInfoDTO> cartInfoDTO) {
			this.cartInfoDTO = cartInfoDTO;
		}



	  	/**
		 * 合計金額を計算するメソッド
		 */
		public int calculateTotalPrice(ArrayList<CartInfoDTO> cartInfoDTO) {
				int totalPrice = 0;
				for(CartInfoDTO dto: cartInfoDTO) {
					totalPrice = dto.getPrice() * dto.getCount();
				}
				return totalPrice;
		}
		public int getCount() {
			return count;
		}


		public void setCount(int count) {
			this.count = count;
		}




		}
