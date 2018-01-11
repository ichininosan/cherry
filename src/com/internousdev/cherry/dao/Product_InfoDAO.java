package com.internousdev.cherry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.cherry.dto.ProductDTO;
import com.internousdev.cherry.util.DBConnector;

public class Product_InfoDAO {

	//初期設定
	private DBConnector db = new DBConnector();
	private Connection con = null;

	private ProductDTO pro_detail;

/*----------------------------------------------------------------------------------------------------------------------
 * 商品一覧表示する
 * -------------------------------------------------------------------------------------------------------------------*/
	public List<ProductDTO> pro_list() throws Exception{

		List<ProductDTO> proList = new ArrayList<ProductDTO>();

		try {

			//フィールドの情報を使ってデータベースへ接続
			con = db.getConnection();


			//SQL準備
			String sql = "SELECT * from product_info order by id desc";


			PreparedStatement pStmt = con.prepareStatement(sql);

			//実行
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {

				int def_id = rs.getInt("ID");
				int product_id = rs.getInt("PRODUCT_ID");
				String product_name = rs.getString("PRODUCT_NAME");
				String product_name_kana = rs.getString("PRODUCT_NAME_KANA");
				String product_description = rs.getString("PRODUCT_DESCRIPTION");
				int category_id = rs.getInt("CATEGORY_ID");
				int price = rs.getInt("PRICE");
				String image_file_name = rs.getString("IMAGE_FILE_NAME");
				String release_date = rs.getString("release_date");
				String release_company = rs.getString("release_company");
				String status = rs.getString("status");
				String regist_date = rs.getString("regist_date");
				String update_date = rs.getString("update_date");

				ProductDTO pro_list = new ProductDTO(def_id, product_id, product_name, product_name_kana, product_description, category_id, price, image_file_name, release_date, release_company, status, regist_date, update_date);

				proList.add(pro_list);


			}

			return proList;


		} finally {
			//データベース切断
			if(con != null){
				try{
					con.close();
				} catch(SQLException e){
					e.printStackTrace();
				}	//catch
			}	//if
		}	//finally



	}	//pro_list

/*----------------------------------------------------------------------------------------------------------------------
 * 商品詳細を表示する
 * -------------------------------------------------------------------------------------------------------------------*/
	public ProductDTO pro_detail(int pro_id) throws Exception{


		try {

			//フィールドの情報を使ってデータベースへ接続
			con = db.getConnection();


			//SQL準備
			String sql = "SELECT * from product_info where id = ?";


			PreparedStatement pStmt = con.prepareStatement(sql);

			//「？」に使用する値を設定し、SQL完成
			pStmt.setInt(1, pro_id);

			//実行
			ResultSet rs = pStmt.executeQuery();

			if(rs.next()) {

				int def_id = rs.getInt("ID");
				int product_id = rs.getInt("PRODUCT_ID");
				String product_name = rs.getString("PRODUCT_NAME");
				String product_name_kana = rs.getString("PRODUCT_NAME_KANA");
				String product_description = rs.getString("PRODUCT_DESCRIPTION");
				int category_id = rs.getInt("CATEGORY_ID");
				int price = rs.getInt("PRICE");
				String image_file_name = rs.getString("IMAGE_FILE_NAME");
				String release_date = rs.getString("release_date");
				String release_company = rs.getString("release_company");
				String status = rs.getString("status");
				String regist_date = rs.getString("regist_date");
				String update_date = rs.getString("update_date");

				ProductDTO pro_detail = new ProductDTO(def_id, product_id, product_name, product_name_kana, product_description, category_id, price, image_file_name, release_date, release_company, status, regist_date, update_date);

				this.pro_detail = pro_detail;


			}

			return  pro_detail;


		} finally {
			//データベース切断
			if(con != null){
				try{
					con.close();
				} catch(SQLException e){
					e.printStackTrace();
				}	//catch
			}	//if
		}	//finally



	}	//pro_list









}	//Product_InfoDAO
