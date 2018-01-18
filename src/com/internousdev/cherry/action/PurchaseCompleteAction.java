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


	private String userId;

    //cart_infoテーブル情報をDAOでList型DTOにしたものを受け取るための箱　(型をそろえる)
	private List<CartInfoDTO> cartList=new ArrayList<CartInfoDTO>();

	public Map<String,Object> session;

	/**
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 * 1.カートテーブルの情報を購入履歴テーブルに保存するメソッド実行
	 * 2.カートテーブルの情報を削除する
	 */

	public String execute() throws SQLException {
		String result = ERROR;

	    PurchaseCompleteDAO purchaseCompleteDAO= new PurchaseCompleteDAO();
//	    CartInfoDTO dto=new CartInfoDTO();

	    if(session.containsKey("userId")){

		    //1.取得メソッド －PurchaseDAOでList型でcartInfoのデータを格納　DTOListで渡す→ActionでList型の箱を作りデータを受け取り
		    cartList=purchaseCompleteDAO.getCartInfo(session.get("userId").toString());
		    if(cartList.size()==0){
				return "other";
		    }

		    
			System.out.println("----PurchaseCompleteAction:execute");
			System.out.println(cartList.get(0).getUserId());
			System.out.println(cartList.get(0).getPrice());
			System.out.println(cartList.get(0).getProductId());
			System.out.println(cartList.get(0).getProductCount());
			System.out.println("------------------------");
		    //2.登録メソッド
	    	int i=purchaseCompleteDAO.setPurchseHistory(cartList);

			if(cartList.size()==i){
			    //2 削除メソッド
			    CartDeleteDAO delete=new CartDeleteDAO();
				delete.deleteCartInfo(session.get("userId").toString());
				result=SUCCESS;
			}
    	}
	    return result;
    }




public String getUserId() {
	return userId;
}

public void setUserId(String userId) {
	this.userId = userId;
}



public List<CartInfoDTO> getCartList() {
	return cartList;
}


public void setCartList(List<CartInfoDTO> cartList) {
	this.cartList = cartList;
}


public Map<String, Object> getSession() {
	return session;
}


public void setSession(Map<String, Object> session) {
	this.session = session;
}


}






