package com.internousdev.cherry.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cherry.dao.MyPageDAO;
import com.internousdev.cherry.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;


public class MyPageAction extends ActionSupport implements SessionAware{


	/**
	 * 1.ログイン状態か確認(sessionにuserIdがあればログイン状態)
	 * 2.未ログインならhome画面に返す
	 * 3.ログイン状態ならユーザー登録情報を取得
	 * 4.sessionに保存
	 */



	//  ユーザーID
	private String userId;

	private Map<String,Object> session;
	//ログイン情報格納DTO
	private ArrayList<MyPageDTO> myPageList = new ArrayList<MyPageDTO>();

	/**
	 * セッション情報を取得する。
	 * userListにセッションの情報が移っており、存在していたらSUCCESS
	 */
	public String execute(){
		String result=ERROR;
		if (session.containsKey("loginDTO")){


		userId = session.get("user_id").toString();

		//ログイン情報取得DAO
		MyPageDAO dao= new MyPageDAO();

		myPageList =dao.getUserInfo(userId);

		  if (myPageList.size() >0){

			result=SUCCESS;
		  }
		}
			return result;

	}

	/**
	 * セッション情報を取得するメソッド
	 * return session
	 */
	public Map<String,Object> getSession(){
		return session;
	}

	/**
	 * セッション情報を格納するメソッド
	 * param session
	 */
	public void setSession1(Map<String, Object> session){
		this.session =session;
	}

	/**
	 *  配列化されたユーザー情報を取得するメソッド
	 * @return UserList
	 */
	public ArrayList<MyPageDTO> getMyPageList(){
		return myPageList;
	}
	/**
	 * DTOに格納された情報をUserListに格納するメソッド
	 * @param userList
	 */
	public void setMyPageList(ArrayList<MyPageDTO> myPageList){
		this.myPageList = myPageList;
	}

	/**
	 * ユーザーIDを取得するメソッド
	 * @return userId
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
	 * セッション情報を格納するメソッド
	 */
	public void setSession(Map<String, Object> arg0) {
		this .session = arg0;
	}

}