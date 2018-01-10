package com.internousdev.cherry.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cherry.dao.SerchDAO;
import com.internousdev.cherry.dto.SerchDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SerchAction extends ActionSupport implements SessionAware{
	private String serchWord;
	private int productId;
	private int categoryId;
	private String errorMsg;
	private SerchDAO serchDAO=new SerchDAO();
	private ArrayList<SerchDTO> serchDTOList=new ArrayList<SerchDTO>();
	private Map<String,Object> session;

/*	private String serchWordCheck(String serchWord){
		String errorMsg="";
		if(serchWord.length()<1 || serchWord.length()>16){
			errorMsg="検索は、1文字以上16字以下で入力してください。";

		}else{
			errorMsg="検索は半角英数字、漢字、カタカナ、ひらがなで入力してください。";
		}return errorMsg;
	}*/

	public String execute(){
		String ret=ERROR;

		if(serchWord.length()>16){
			errorMsg="検索は、16字以下で入力してください。";
			session.put("errorMsg",errorMsg);
			System.out.println(errorMsg);
			return ERROR;

		}


		if(serchWord.matches("^[\\u3040-\\u309F]+$")){
			System.out.println("全てひらがな");
		}else if(serchWord.matches("^[\\u30A0-\\u30FF]+$")){
			System.out.println("全てカタカナ");
		}


		/*
		全件検索(カテゴリ、検索値なし)

		*/

		if(categoryId==1&&serchWord.isEmpty()){
			serchDTOList=serchDAO.allProductInfo();
			ret=SUCCESS;

		}

		/*
		カテゴリ有り、検索値なし
		 */
		else if(categoryId>1&&serchWord.isEmpty()){

			serchDTOList=serchDAO.ByProductCategory(categoryId);
			ret=SUCCESS;
		}

		/*
		カテゴリなし、検索値あり
		 */
		else if(categoryId==1&&!(serchWord.isEmpty())){
			serchDTOList=serchDAO.BySerchWord(serchWord);
			ret=SUCCESS;
		}

		/*
		カテゴリあり、検索値あり
		 */
		else{
			serchDTOList=serchDAO.ByCategoryANDSerchWord(categoryId, serchWord);
			ret=SUCCESS;

		}return ret;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
