package com.internousdev.cherry.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

import com.internousdev.cherry.dao.CartDeleteDAO;
import com.internousdev.cherry.dao.CartInfoDAO;
import com.internousdev.cherry.dto.CartInfoDTO;

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


    /**
     * 　セッション情報
     */
    private Map<String, Object> session;

    /**
     * 　検索したカート内の商品の情報を入れるリスト
     */
    private List<CartInfoDTO> cartList = new ArrayList<>();


    /**
     * カート情報を削除するメソッド
     *
     */

     /**
     * 実行メソッド 処理内容と順番
     * 1：ログインしているかを確認
     * 2：カートからその商品のデータを削除
     * 3：カートの情報を取得
     */


    public String execute(){
        String result = ERROR;


        if (session.containsKey("userId")) {
            userId = session.get("userId").toString();
            CartDeleteDAO deletedao=new CartDeleteDAO();

            }
            result="other";

        //カートに接続しデータが入っていないことを表示
            CartInfoDAO cartdao= new CartInfoDAO();
            cartList=cartdao.getCartInfo(userId);
            if(cartList==null){

            }
            result=SUCCESS;


        }
        return result;


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
    public List<CartInfoDTO> getCartList() {
        return cartList;
    }

    /**
     * カート内の商品情報を格納するためのメソッド
     * @param cartList セットする cartList
     */
    public void setCartList(List<CartInfoDTO> cartList) {
        this.cartList = cartList;
    }


    }



