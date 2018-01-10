package com.internousdev.cherry.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.internousdev.cherry.dao.Product_InfoDAO;
import com.internousdev.cherry.dto.ProductDTO;
import com.opensymphony.xwork2.ActionSupport;


public class ProDetailAction extends ActionSupport  implements ServletRequestAware{

	HttpServletRequest request;



	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletRequest getServletRequest() {
		return this.request;
	}




	protected void doGet(String pro_idA) throws ServletException, IOException {
		//ロード
		request.setCharacterEncoding("UTF-8");

		int pro_id = Integer.parseInt(pro_idA);
		Product_InfoDAO dao = new Product_InfoDAO();
		HttpSession session = request.getSession();


		try {
			ProductDTO pro_detail = dao.pro_detail(pro_id);
			session.setAttribute("pro_detail", pro_detail);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		};


	}

	public String execute(){

		/*	private String id = request.getParameter("id");*/
		String id = getServletRequest().getParameter("id");

		try {
			doGet(id);
		} catch (ServletException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}



		return SUCCESS;
	}

}
