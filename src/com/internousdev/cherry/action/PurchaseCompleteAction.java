package com.internousdev.cherry.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cherry.dao.CartDeleteDAO;
import com.internousdev.cherry.dao.PurchaseCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class PurchaseCompleteAction extends ActionSupport implements SessionAware{


	private String userId;


	public Map<String,Object> session;

	/**
	 * (非 Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 * 1.カートテーブルの情報を購入履歴テーブルに保存するメソッド実行
	 * 2.カートテーブルの情報を削除する
	 */

	public String execute () throws SQLException {
		String result = ERROR;

    PurchaseCompleteDAO purchaseCompleteDAO= new PurchaseCompleteDAO();


    purchaseCompleteDAO.putCartInfo(session.get("userId").toString());


    //2 削除メソッド
    CartDeleteDAO delete=new CartDeleteDAO();
	delete.deleteCartInfo(session.get("userId").toString());

		result=SUCCESS;

	}
	return result;

//ここのエラーが解消できない



public String getUserId() {
	return userId;
}

public void setUserId(String userId) {
	this.userId = userId;
}


public Map<String, Object> getSession() {
	return session;
}


public void setSession(Map<String, Object> session) {
	this.session = session;
}


}






