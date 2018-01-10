package com.internousdev.cherry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.cherry.util.DBConnector;


public class PurchaseCompleteDAO {

	    private DBConnector db= new DBConnector();

		private Connection con = db.getConnection();


		//カートテーブルを購入履歴に登録するメソッド

		public void putCartInfo(String userId) throws SQLException {

			String sql= "INSERT INTO purcahse_history_info (product_id, product_count, price, regist_date, update_date) SELECT (product_id, product_count, price, regist_date, update_date from cart_info ci wehre ci.user_id=user_id ";

			try {

				PreparedStatement ps = con.prepareStatement(sql);
				ps.executeQuery();

				}catch (SQLException e) {
				e.printStackTrace();

			} finally {
				con.close();

			}


		}
}
