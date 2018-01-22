package com.internousdev.cherry.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cherry.dao.CartDeleteDAO;
import com.internousdev.cherry.dao.CartInfoDAO;
import com.internousdev.cherry.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 *  カート内の商品を削除するクラス
 *
 */

public class CartDeleteAction extends ActionSupport implements SessionAware {



    /**
     * ユーザーID
     */
    private String userId;

    /**
     * 商品ID
     */
    private int itemId;
    private String productId;


    /**
     * 　セッション情報
     */
    private Map<String, Object> session;

    /**
     * 　検索したカート内の商品の情報を入れるリスト
     */
    private ArrayList<CartInfoDTO> cartList = new ArrayList<CartInfoDTO>();



    int totalPrice;







    /**
     * カート情報を削除するメソッド
     *
     */

     /**
     * 実行メソッド 処理内容と順番
     * 1：ログインしているかを確認
     * 2：カートからその商品のデータを削除
     * 3：カートの情報を取得
     * @throws SQLException
     */


    public String execute() throws SQLException{
        String result = ERROR;
        CartInfoDAO dao = new CartInfoDAO();
        CartDeleteDAO deletedao=new CartDeleteDAO();

        if(!(session.containsKey("userId"))){
        	deletedao.deleteSeparate(session.get("tempUserId").toString(),productId);
        	cartList=dao.showUserCartList(session.get("tempUserId").toString());
        }else{



/*        if (session.containsKey("userId")) {*/
            userId = session.get("userId").toString();//ログインしているuserId
            deletedao.deleteSeparate(userId,productId);
            cartList=dao.showUserCartList(session.get("userId").toString());
        }
            /*for(CartInfoDTO dto: dao.showUserCartList(session.get("userId").toString())){
				cartList.add(dto);
			}*/

    		totalPrice = calcTotalPrice(cartList);

    		//暫定でセッション値セット//
/*    		session.put("loginFlg",true);
    		session.put("userId", "a");
*/
    		//ログインユーザーのカート情報を引き出す
    		/*
            if(session.containsKey("loginFlg") && (boolean) session.get("loginFlg")){
    		*/
            	//  if(session.containsKey("userId")){
/*    			for(CartInfoDTO dto: dao.showUserCartList(session.get("userId").toString())){
    				cartList.add(dto);
    			}*/
    		//非ログインユーザーのカート情報を引き出す
    		/*}else{
    			for(CartInfoDTO dto: dao.showTempUserCartList(session.get("tempUserId").toString())){
    				cartList.add(dto);
    			}
    		}*/


        //カートに接続しデータが入っていないことを表示
           /* CartInfoDAO cartdao= new CartInfoDAO();
            cartList=cartdao.aquireUserCartInfo(userId);
            System.out.println("削除完了");

            if(cartList==null){


            	 }*/

            result=SUCCESS;

        return result;
    }


    /**
     * ユーザーIDを取得するためのメソッド
     * @return userId ユーザーID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * ユーザーIDを格納するためのメソッド
     * @param userId セットする userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * アイテムIDを取得するためのメソッド
     * @return itemId ユーザーID
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * アイテムIDを格納するためのメソッド
     * @param itemId セットする itemId
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }


    /**
     * セッションを取得するためのメソッド
     * @return session セッション情報
     */
    public Map<String, Object> getSession() {
        return session;
    }

    /**
     * セッションを格納するためのメソッド
     * @param session セットする session
     */
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    /**
     * カート内の商品情報を取得するためのメソッド
     * @return cartList カート内の商品情報
     */



	public String getProductId() {
		return productId;
	}


	public ArrayList<CartInfoDTO> getCartList() {
		return cartList;
	}


	public void setCartList(ArrayList<CartInfoDTO> cartList) {
		this.cartList = cartList;
	}


	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int calcTotalPrice(ArrayList<CartInfoDTO> cartList) {
		int totalPrice = 0;
		for(CartInfoDTO dto: cartList) {
			totalPrice += dto.getPrice() * dto.getProductCount();
			System.out.println("合計" + totalPrice + "円");
		}
		return totalPrice;
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


}



