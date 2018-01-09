package com.internousdev.cherry.action;

import java.util.ArrayList;

import com.internousdev.cherry.dao.SerchDAO;
import com.internousdev.cherry.dto.SerchDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SerchAction extends ActionSupport{
	private String serchWord;
	private int productId;
	private int categoryId;
	private String errorMsg;
	private SerchDAO serchDAO=new SerchDAO();
	private ArrayList<SerchDTO> serchDTOList=new ArrayList<SerchDTO>();

	public String execute(){
		String ret=ERROR;

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

		}







	return ret;
	}

}
