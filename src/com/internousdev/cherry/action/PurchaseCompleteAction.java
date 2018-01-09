package com.internousdev.cherry.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;


public class PurchaseCompleteAction extends ActionSupport implements SessionAware{

	private ArrayList<CartInfoDTO> cartInfoDTO = new ArrayList<CartInfoDTO>();
	private  Map<String,Object> session;
	private  ProductInfoDTO productInfoDTO=new ProductInfoDTO();


	/**
	 * カート情報登録完了メソッド
	 */
	public String execute() throws SQLException{
			String result = SUCCESS;

			CartInfoDAO cartinfoDAO = new CartInfoDAO();//カート情報取得DAO
			ArrayList<CartInfoDTO> cartInfoDTO = new ArrayList<CartInfoDTO>();//カート情報格納DTO
			PurchaseHistoryDAO purchaseHistoryDAO=new PurchaseHistoryDAO();//購入履歴取得DAO



			cartInfoDTO = cartInfoDAO.getUserCartInfo(session.get("userId").toString());

			cartInfoDAO.deleteUserCartInfo(session.get("userId").toString());

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



		public ProductInfoDTO getProductInfoDTO() {
			return productInfoDTO;
		}



		public void setProductInfoDTO(ProductInfoDTO productInfoDTO) {
			this.productInfoDTO = productInfoDTO;
		}






		}
