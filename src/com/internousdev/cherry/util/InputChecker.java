package com.internousdev.cherry.util;

public class InputChecker {

	/**
	 * 入力チェック全般を担当します。
	 * @author internousdev
	 * @return
	 */
	public String fmilyNameChk(String familyName){
		String result = "OK";

		if(familyName.equals("")){
			result = "姓を入力してください。";
		}else if(familyName.length() < 1 || familyName.length() > 16){
			result = "姓は１文字以上１６文字以下で入力してください。";
		}else if(!familyName.matches("^[a-zA-Z一-龠あ-ん]+$")){
			result = "姓は半角英語、またはひらがなで入力してください。";
		}
		return result;
	}

}
