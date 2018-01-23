
package com.internousdev.cherry.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cherry.dao.ResetPasswordDAO;
import com.internousdev.cherry.dto.UserInfoDTO;
import com.internousdev.cherry.util.ErrorMessageConstants;
import com.internousdev.cherry.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordConfirmAction extends ActionSupport implements SessionAware,ErrorMessageConstants {

	//ユーザーID
	private String userId;
	//新規パスワード
	private String password;
	//確認用パスワード
	private String passwordc;

	//パスワードの先頭2文字
	private String confirmpass;
	//パスワードの3文字目以降
	private String confirmpass3;
	//確認画面で表示する先頭以外*のパスワード
	private String s;

	//エラーメッセージリスト
	private ArrayList<String> errMsgList = new ArrayList<>();
	//セッション
	public Map<String,Object> session;
	//DAO,DTO
	private ResetPasswordDAO DAO = new ResetPasswordDAO();
	private UserInfoDTO userInfoDTO = new UserInfoDTO();


	//メソッドの実行
	public String execute(){
		String result =SUCCESS;
		userInfoDTO=DAO.UserInfoByUserId(userId);
		String str=userInfoDTO.getUserId();

		//インプットチェッカー利用して条件判定とエラーメッセージ表示
		InputChecker i = new InputChecker();
		if(!i.userIdChk(userId).equals("OK")){
			errMsgList.add(i.userIdChk(userId));
			result = ERROR;
		}
		if(!i.passwordChk(password).equals("OK")){
			errMsgList.add(i.passwordChk(password));
			result = ERROR;
		}
		if(!i.passwordcChk(passwordc,password).equals("OK")){
			errMsgList.add(i.passwordcChk(passwordc,password));
			result = ERROR;
		}

		//入力されたuserIdがDBにあるか(会員登録済みか)チェック
		if(i.userIdChk(userId).equals("OK")
				&& i.passwordChk(password).equals("OK")
				&& i.passwordcChk(passwordc,password).equals("OK")){
			if(str==null || str.isEmpty()){
			errMsgList.add("このIDは存在しません。登録済みのIDを入力してください。");
			result = ERROR;
			}
		}

		//パスワードが4文字以上のとき、最初の2文字のみ表示して、3文字以降を*で表示する
		if(password.length() > 3){
			session.put("newUserId", userId);
			session.put("newPassword", password);
			confirmpass = password.substring(0,2);
			confirmpass3 = password.substring(2).replaceAll("^[0-9a-zA-Z]+$","*");
			s = confirmpass + confirmpass3;
		//パスワードが3文字以下のとき、*で表示する
		}else{
			session.put("newUserId", userId);
			session.put("newPassword", password);
			s = password.replaceAll("^[0-9a-zA-Z]+$","*");
		}


		 System.out.println("userIDは"+userInfoDTO.getUserId());

		return result;
	}


	//ユーザーIDのゲッターセッター
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	//新規パスワードのゲッターセッター
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	//確認用パスワードのゲッターセッター
	public String getPasswordc() {
		return passwordc;
	}
	public void setPasswordc(String passwordc) {
		this.passwordc = passwordc;
	}

	//DAO,DTOのゲッター、セッター
	public ResetPasswordDAO getDAO() {
		return DAO;
	}
	public void setDAO(ResetPasswordDAO dAO) {
		DAO = dAO;
	}
	public UserInfoDTO getUserInfoDTO() {
		return userInfoDTO;
	}
	public void setUserInfoDTO(UserInfoDTO userInfoDTO) {
		this.userInfoDTO = userInfoDTO;
	}


	//パスワード先頭二文字のゲッターセッター
	public String getConfirmpass() {
		return confirmpass;
	}
	public void setConfirmpass(String confirmpass) {
		this.confirmpass = confirmpass;
	}

	//パスワード3文字以降のゲッターセッター
	public String getConfirmpass3() {
		return confirmpass3;
	}
	public void setConfirmpass3(String confirmpass1) {
		this.confirmpass3 = confirmpass1;
	}

	//確認画面用パスワードのゲッターセッター
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}

	//エラーメッセージのゲッターセッター
	public ArrayList<String> getErrMsgList() {
		return errMsgList;
	}
	public void setErrMsgList(ArrayList<String> errMsgList) {
		this.errMsgList = errMsgList;
	}

	//セッションのゲッターセッター
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
