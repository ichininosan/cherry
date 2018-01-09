package com.internousdev.cherry.action;

import java.util.ArrayList;

import com.internousdev.cherry.util.ErrorMessageConstants;
import com.internousdev.cherry.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;



public class DestinationInfoConfirmAction extends ActionSupport implements ErrorMessageConstants{

	private String fmilyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String email;
	private String telNumber;
	private String userAddress;
	private ArrayList<String> errMsgList = new ArrayList<>();

	public String execute(){
		String result = SUCCESS;

		InputChecker i = new InputChecker();
	}

}
