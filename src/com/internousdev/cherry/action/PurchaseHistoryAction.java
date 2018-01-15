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
 *
 *       (要) executeメソッドとdeleteメソッドの
 *        user_idをsessionからひっぱれるようにする！
 *  1/12
 *  個別削除でListからもけしたい！！
 *  //historyList.remove(id); Listから消せるかも！
 *
 */
public class PurchaseHistoryAction extends ActionSupport implements SessionAware{
	/*
	 *セッション
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
	 * 個別削除id取得
	 */
	private int id;




	/*
	 * 商品購入履歴取得メソッド
	 */
	public String execute()throws SQLException{
		String result = SUCCESS;

		//sessionからもってこれるようにする
		String user_id = "a";

		if(deleteFlg == null){

			//session.get("user_id").toString()せっっしょンの名前！
			historyList = purchaseHistoryDAO.getPurchaseHistory(user_id);


			System.out.println("List = "+historyList);


			Iterator<PurchaseHistoryDTO> iterator = historyList.iterator();


			if(!(iterator.hasNext())){
				historyList = null;
			}
		} else if(deleteFlg.equals("1")){
			//すべて削除メソッド
			delete();
			historyList = null;

		} else if(deleteFlg.equals("2")){
			//個別削除メソッド
			System.out.println("ID:"+id);
			deletePart(id);//個別削除メソッド
			historyList = null;
			historyList = purchaseHistoryDAO.getPurchaseHistory(user_id);


		}

		//historyList = purchaseHistoryDAO.getPurchaseHistory(user_id);

		return result;
	}

	/*
	 * 購入履歴削除メソッド
	 */
	public void delete() throws SQLException{
		//sessionからもってこれるようにする
		String user_id = "a";


		int res = purchaseHistoryDAO.deleteHistory(user_id);
		System.out.println("削除しようとする件数："+res);
		if(res > 0){
			System.out.println("削除した");
			historyList = null;
			setMessage("商品を正しく削除しました。");
		}else if(res == 0){
			System.out.println("削除失敗");
			setMessage("商品の削除に失敗しました。");
		}

	}

	/*
	 * 履歴個別削除メソッド
	 */
	public void deletePart(int id) throws SQLException{
		//jspからもってきた
		id = this.id;


		//historyList.remove(id); Listから消せるかも！
		int res2 = purchaseHistoryDAO.deletePart(id);

		if(res2 > 0){

			setMessage("商品を正しく削除しました。");
		}else if(res2 == 0){
			System.out.println("個別：削除失敗");
			setMessage("商品の削除に失敗しました。");
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
	 * jspからIDもってくる
	 */
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
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






















