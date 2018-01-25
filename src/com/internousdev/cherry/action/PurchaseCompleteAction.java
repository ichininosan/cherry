package com.internousdev.cherry.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cherry.dao.CartDeleteDAO;
import com.internousdev.cherry.dao.PurchaseCompleteDAO;
import com.internousdev.cherry.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class PurchaseCompleteAction extends ActionSupport implements SessionAware{

	/**
	 * カートテーブルの情報を購入履歴テーブルに保存するメソッド実行
	 * 1.カート情報取得
	 * 2.購入履歴に登録
	 * 3.カートテーブルの情報を削除する
	 * @param userId
	 */
	//userId格納
	private String userId;
	//cartInfoDTO格納List
	private List<CartInfoDTO> cartList=new ArrayList<CartInfoDTO>();
	//session情報格納
	public Map<String,Object> session;

	public String execute() throws SQLException {
		String result = ERROR;
		/*---------------------------------------------------------
	    	1.カート情報取得（List型で受け取る）
 		---------------------------------------------------------*/
		PurchaseCompleteDAO purchaseCompleteDAO= new PurchaseCompleteDAO();
		if(session.containsKey("userId")){
			cartList=purchaseCompleteDAO.getCartInfo(session.get("userId").toString());

		/*---------------------------------------------------------
	    	カート情報なしの場合
 		---------------------------------------------------------*/
			if(cartList.size()==0){
				return "other";
			}

		    /*コンソールに処理を表示-------------------------------*/
			System.out.println("----PurchaseCompleteAction:execute");
			System.out.println(cartList.get(0).getUserId());
			System.out.println(cartList.get(0).getPrice());
			System.out.println(cartList.get(0).getProductId());
			System.out.println(cartList.get(0).getProductCount());
			System.out.println("------------------------");
			/*------------------------------------------------------*/

		/*---------------------------------------------------------
	    	2.購入履歴に登録
 		---------------------------------------------------------*/

			int i=purchaseCompleteDAO.setPurchseHistory(cartList);

	    /*---------------------------------------------------------
	    	カート情報ありの場合(listの数と処理件数と同じ場合)
 		---------------------------------------------------------*/
			if(cartList.size()==i){
	    /*---------------------------------------------------------
		    	2.購入履歴に登録
	    ---------------------------------------------------------*/
				CartDeleteDAO delete=new CartDeleteDAO();
				delete.deleteCartInfo(session.get("userId").toString());
				result=SUCCESS;
				}
		}
		return result;
	}




	/**
	 * ユーザーIDを取得するメソッド
	 *@return userId
	 */
	public String getUserId(){
		return userId;
	}
	/**
 	 * ユーザーIDを格納するメソッド
	 * @param userId
	 */
	public void setUserId(String userId){
		this.userId =userId;
	}
	/**
	 * ユーザーcartListを取得するメソッド
	 *@return cartList
	 */
	public List<CartInfoDTO> getCartList() {
		return cartList;
	}
	/**
	 * ユーザーcartListを取得するメソッド
	 *@return cartList
	 */
	public void setCartList(List<CartInfoDTO> cartList) {
		this.cartList = cartList;
	}
	/**
	 * セッション情報を取得するメソッド
	 * @return session
	 */
	public Map<String,Object> getSession(){
		return session;
	}
	/**
	 * セッション情報を格納するメソッド
	 * @param session
	 */
	public void setSession(Map<String, Object> session){
		this.session =session;
	}






}






