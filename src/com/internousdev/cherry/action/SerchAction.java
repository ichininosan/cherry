package com.internousdev.cherry.action;

import java.text.Normalizer;
import java.util.ArrayList;

import com.internousdev.cherry.dao.SerchDAO;
import com.internousdev.cherry.dto.SerchDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SerchAction extends ActionSupport{
	private String serchWord;
	private int categoryId;
	private SerchDAO serchDAO=new SerchDAO();
	private ArrayList<SerchDTO> serchDTOList=new ArrayList<SerchDTO>();

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

		serchWord=Normalizer.normalize(serchWord, Normalizer.Form.NFKC);
		System.out.println(serchWord);



		/*
		ひらがな検索
		*/

		if(categoryId==1&&serchWord.matches("^[\\u3040-\\u309F]+$")){
			setSerchDTOList(serchDAO.BySerchWordKana(serchWord));
			ret=SUCCESS;

		}
		else if(categoryId>1&&serchWord.matches("^[\\u3040-\\u309F]+$")){
			setSerchDTOList(serchDAO.ByCategoryANDSerchWordKana(categoryId, serchWord));
			ret=SUCCESS;

		}

		/*
		全件検索(カテゴリ、検索値なし)

		*/

		else if(categoryId==1&&serchWord.isEmpty()){
			setSerchDTOList(serchDAO.allProductInfo());
			ret=SUCCESS;

		}
		/*
		ひらがな、カタカナ検索
		*/
		else if(categoryId==1&&(serchWord.matches("^[\\u3040-\\u309F]+$")||
				serchWord.matches("^[\\u30A0-\\u30FF]+$"))){

		}else if(categoryId>1&&(serchWord.matches("^[\\u3040-\\u309F]+$")||
				serchWord.matches("^[\\u30A0-\\u30FF]+$"))){

		}


		/*
		カテゴリ有り、検索値なし
		 */
		else if(categoryId>1&&serchWord.isEmpty()){

			setSerchDTOList(serchDAO.ByProductCategory(categoryId));
			ret=SUCCESS;
		}

		/*
		カテゴリなし、検索値あり
		 */
		else if(categoryId==1&&!(serchWord.isEmpty())){
			setSerchDTOList(serchDAO.BySerchWord(serchWord));
			ret=SUCCESS;
		}

		/*
		カテゴリあり、検索値あり
		 */
		else{
			setSerchDTOList(serchDAO.ByCategoryANDSerchWord(categoryId, serchWord));
			ret=SUCCESS;

		}return ret;
	}


	public ArrayList<SerchDTO> getSerchDTOList() {
		return serchDTOList;
	}

	public void setSerchDTOList(ArrayList<SerchDTO> serchDTOList) {
		this.serchDTOList = serchDTOList;
	}

}
