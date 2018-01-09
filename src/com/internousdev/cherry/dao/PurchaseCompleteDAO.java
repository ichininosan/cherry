package com.internousdev.cherry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.cherry.util.DBConnector;
import com.internousdev.cherry.util.DateUtil;;



public class PurchaseCompleteDAO {

	private DBConnector db=new DBConnector();
	private Connection con=db.getConnection();
	private DateUtil dateUtil=new DateUtil();

	      /**
	       * 購入履歴にカートの情報を挿入
	       * @param userId
	       * @param productId
	       * @throws SQLException
	       */

		public void purchaseHistoryInfo(String userId,int productId,int count) throws SQLException{
			Connection con=db.getConnection();
			String sql = "INSERT INTO purchase_history_info(user_id,product_id,count,insert_date)  VALUES(?,?,?,NOW())";

			try{
				PreparedStatement preparedStatement = con.prepareStatement(sql);
			    preparedStatement.setString(1,userId);
			    preparedStatement.setInt(2, productId);
			    preparedStatement.setInt(3, count);

			    preparedStatement.execute();

			}catch(Exception e){
				e.printStackTrace();
			}try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}

			/**
			 * カートの情報を削除
			 * @param userId
			 */

			public void deleteUserCartInfo(String userId) {
				Connection con=db.getConnection();
				String sql = "DELETE FROM cart_info WHERE user_id = ?";

				try{
				PreparedStatement preparedStatement = con.prepareStatement(sql);
				preparedStatement.setString(1, userId);

				preparedStatement.execute();

			}catch(Exception e){
				e.printStackTrace();
			}try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}

			}




	}