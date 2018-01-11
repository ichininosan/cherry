package com.internousdev.cherry.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cherry.dao.PurchaseHistoryDAO;
import com.internousdev.cherry.dto.PurchaseHistoryDTO;
import com.opensymphony.xwork2.ActionSupport;

/*
 * マイページからボタン押して遷移
 */
public class PurchaseHistoryAction extends ActionSupport implements SessionAware{
	/*
	 *
	 */
	public Map<String, Object> session;

	/*
	 * 商品購入履歴取得DAO
	 */
	private PurchaseHistoryDAO purchaseHistoryDAO = new PurchaseHistoryDAO();

	/*
	 * 商品購入履歴格納DTO List
	 */
	public ArrayList<PurchaseHistoryDTO> historyList = new ArrayList<PurchaseHistoryDTO>();

	/*
	 * 削除フラグ
	 */
	private String deleteFlg;

	/*
	 * 削除メッセージ
	 */
	private String message;

	/*
	 * 商品購入履歴取得メソッド
	 */
	public String execute()throws SQLException{
		String result = SUCCESS;


		if(deleteFlg == null){
			String user_id = session.get("セッション名！").toString();
			historyList = purchaseHistoryDAO.getPurchaseHistory(user_id);
			Iterator<PurchaseHistoryDTO> iterator = historyList.iterator();

			if(!(iterator.hasNext())){
				historyList = null;
			}
		} else if(deleteFlg.equals("1")){
			delete();
		}

		return result;
	}

	/*
	 * 購入履歴削除メソッド
	 */
	public void delete() throws SQLException{
		historyList = null;
		if(historyList == null){
			setMessage("商品購入履歴を削除しました！！");
		}else if(!(historyList == null)){
			setMessage("商品購入履歴の削除に失敗しました！！");
		}
	}


	/*
	 *deleteFlg
	 */
	public String getDeleteFlg(){
		return deleteFlg;
	}
	public void setDeleteFlg(String deleteFlg){
		this.deleteFlg = deleteFlg;
	}

	/*
	 * 削除メッセージ
	 */
	public String getMessage(){
		return message;
	}
	public void setMessage(String message){
		this.message = message;
	}

	/*
	 * session
	 */
	public void setSession(Map<String, Object> session){
		this.session = session;
	}


}






















