package com.internousdev.cherry.dto;

import java.util.Date;

public class CartInfoDTO {

	private int id;
	private String userId;
	private String tempUserId;
	private int productId;
	private int productCount;
	private int price;
	private Date insertDate;
	private Date updateDate;

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	public String getuserId(){
		return userId;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getTempUserId(){
		return tempUserId;
	}

	public void setTempUserId(String tempUserId){
		this.tempUserId = tempUserId;
	}

	public int getProductId(){
		return productId;
	}

	public void setProductId(int productId){
		this.productId = productId;
	}

	public int getProductCount(){
		return productCount;
	}

	public void setProductCount(int productCount){
		this.productCount = productCount;
	}

	public int getPrice(){
		return price;
	}

	public void setPrice(int price){
		this.price = price;
	}

	public Date getInsertDate(){
		return insertDate;
	}

	public void setInsertDate(Date insertDate){
		this.insertDate = insertDate;
	}

	public Date getUpdateDate(){
		return updateDate;
	}

	public void setUpdateDate(Date updateDate){
		this.updateDate = updateDate;
	}

}



















