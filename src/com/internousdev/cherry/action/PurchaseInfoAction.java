package com.internousdev.cherry.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cherry.dto.DestinationInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class PurchaseInfoAction extends ActionSupport implements SessionAware{

	/**
	 * セッション
	 */
	private Map<String, Object> session;

	/**
	 * 合計金額
	 */
	private int totalPrice = 0;

	/**
	 * 個数
	 */
	private int count;

	/**
	 * カード情報一覧
	 */
	private List<CartInfoDTO> cartInfoDTOList = new ArrayList<CartInfoDTO>();

	/**
	 * 宛先情報一覧
	 */
	private ArrayList<DestinationInfoDTO> addressInfoDTOList = new ArrayList<DestinationInfoDTO>();

	/**
	 * 決済情報取得メソッド
	 */
	public String execute() throws SQLException{
		CartInfoDAO cartInfoDAO = new CartInfoDAO();
		cartInfoDTOList = cartInfoDAO.showUserCartList(session.get("userId").toString());

		for(CartInfoDTO dto:cartInfoDTOList) {
			totalPrice +=dto.getPrice() * dto.getCount();

		}

		if (cartInfoDTOList.size() > 0) {
			result = SUCCESS;

		} else {
			result = ERROR;
		}

		/**
		 * 宛先情報取得メソッド
		 */
		AddressInfoDAO addressInfoDAO = new AddressInfoDAO();
		addressInfoListDTO = addressInfoDAO.obtainingaddressInfo(session.get("userId").toString());

		if(addressInfoListDTO.size() > 0) {
			result = SUCCESS;

		} else if(!(boolean) session.get("loginFlg")) {
			result=ERROR;

		} else {
			result = "ADDRESS";

		}

		return result;
	}

}

























