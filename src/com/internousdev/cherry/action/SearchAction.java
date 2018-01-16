package com.internousdev.cherry.action;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.cherry.dao.SearchDAO;
import com.internousdev.cherry.dto.SearchDTO;
import com.internousdev.cherry.util.ToHiragana;
import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport implements SessionAware{
	private String searchWord;
	private int categoryId;
	private SearchDAO searchDAO=new SearchDAO();
	private ArrayList<SearchDTO> searchDTOList=new ArrayList<SearchDTO>();
	private ToHiragana toHiragana=new  ToHiragana();
	public Map<String,Object> session;

/*	private String serchWordCheck(String serchWord){
		String errorMsg="";
		if(serchWord.length()<1 || serchWord.length()>16){
			errorMsg="検索は、1文字以上16字以下で入力してください。";

		}else{
			errorMsg="検索は半角英数字、漢字、カタカナ、ひらがなで入力してください。";
		}return errorMsg;
	}*/
/*	private String[] createKeywords(String keyword) {
		// 全角を半角に置き換えて、文字列を" "で分割する
		keyword = keyword.replace("　", " ");
		String[] keywords = keyword.split(" ", 0);
		return keywords;
	}
*/
	public String execute(){
		String ret=ERROR;

		/*
		検索値を全て全角ひらがな、全角カタカナに変換
		 */
		searchWord=Normalizer.normalize(searchWord, Normalizer.Form.NFKC);
		System.out.println(searchWord);


		/*
		ひらがな検索
		*/

/*		if(categoryId==1&&searchWord.matches("^[\\u3040-\\u309F]+$")){
			setSearchDTOList(searchDAO.BySerchWordKana(searchWord));
			ret=SUCCESS;

		}
		else if(categoryId>1&&searchWord.matches("^[\\u3040-\\u309FF]+$")){
			searchWord=toHiragana.toZenkakuHiragana(searchWord);
			System.out.println(searchWord);
			setSearchDTOList(searchDAO.ByCategoryANDSerchWordKana(categoryId, searchWord));
			ret=SUCCESS;

		}*/

		/*
		全件検索(カテゴリ、検索値なし)

		*/

		if(categoryId==1&&searchWord.isEmpty()){
			setSearchDTOList(searchDAO.allProductInfo());
			ret=SUCCESS;

		}
/*
		ひらがな、カタカナ検索
		*/
		else if(categoryId==1&&(searchWord.matches("^[\\u3040-\\u309F]+$")||
				searchWord.matches("^[\\u30A0-\\u30FF]+$"))){
			searchWord=toHiragana.toZenkakuHiragana(searchWord);
			System.out.println(searchWord);
			setSearchDTOList(searchDAO.BySerchWordKana(searchWord));
			ret=SUCCESS;


		}else if(categoryId>1&&(searchWord.matches("^[\\u3040-\\u309F]+$")||
				searchWord.matches("^[\\u30A0-\\u30FF]+$"))){
			searchWord=toHiragana.toZenkakuHiragana(searchWord);
			System.out.println(searchWord);
			setSearchDTOList(searchDAO.ByCategoryANDSerchWordKana(categoryId, searchWord));
			ret=SUCCESS;

		}


		/*
		カテゴリ有り、検索値なし
		 */
		else if(categoryId>1&&searchWord.isEmpty()){

			setSearchDTOList(searchDAO.ByProductCategory(categoryId));
			ret=SUCCESS;
		}

		/*
		カテゴリなし、検索値あり
		 */
		else if(categoryId==1&&!(searchWord.isEmpty())){
			setSearchDTOList(searchDAO.BySerchWord(searchWord));
			ret=SUCCESS;
		}

		/*
		カテゴリあり、検索値あり
		 */
		else{
			setSearchDTOList(searchDAO.ByCategoryANDSerchWord(categoryId, searchWord));
			ret=SUCCESS;

		}return ret;
	}




	public String getSearchWord() {
		return searchWord;
	}




	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}




	public int getCategoryId() {
		return categoryId;
	}




	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}




	public SearchDAO getSearchDAO() {
		return searchDAO;
	}




	public void setSearchDAO(SearchDAO searchDAO) {
		this.searchDAO = searchDAO;
	}




	public ArrayList<SearchDTO> getSearchDTOList() {
		return searchDTOList;
	}

	public void setSearchDTOList(ArrayList<SearchDTO> searchDTOList) {
		this.searchDTOList = searchDTOList;
	}




	public ToHiragana getToHiragana() {
		return toHiragana;
	}




	public void setToHiragana(ToHiragana toHiragana) {
		this.toHiragana = toHiragana;
	}




	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO 自動生成されたメソッド・スタブ

	}



}
