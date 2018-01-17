package com.internousdev.cherry.action;

import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordAction extends ActionSupport/* implements SessionAware*/{
/*	public Map<String, Object> session;
*/	private String userId;
	private boolean saveLogin;
	private String saveId;


	//LoginDAO loginDAO = new LoginDAO();
	//UserInfoDTO userInfoDTO = new UserInfoDTO();

	public String execute(){

		System.out.println(userId);
		String ret=SUCCESS;
		return ret;
	}
/**
		//ログイン画面で入力されたuserIdをsessioに保管
		if ((!userId.equals("")) && loginDAO.existsUserId(userId)) {

			//会員情報DTOにuserIdとパスワードを設置
			userInfoDTO = loginDAO.select(userId,password);

			//sessionにuserIdを保管、チェックボックスしてるか
			session.put("userId", userInfoDTO.getUserId());
			session.put("saveLogin", true);
		}

		//DAOのインスタンス作成
			ResetPasswordDAO dao = new ResetPasswordDAO();

		//チェックボックスかつID入力時→再設定画面でuserID表示
			if((!(userId.equals("")))&&saveLogin){
			//userIdをDBから探す
			session.put("userId", dao.getUserId(userId));
			return result;
		}else{
			return ERROR;
		}
*/

	//ゲッター、セッター
/*	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
*/
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean isSaveLogin() {
		return saveLogin;
	}
	public void setSaveLogin(boolean saveLogin) {
		this.saveLogin = saveLogin;
	}

	public String getSaveId() {
		return saveId;
	}
	public void setSaveId(String saveId) {
		this.saveId = saveId;
	}
}