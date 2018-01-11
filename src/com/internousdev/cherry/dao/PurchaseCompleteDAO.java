package com.internousdev.cherry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.cherry.dto.CartInfoDTO;
import com.internousdev.cherry.util.DBConnector;


public class PurchaseCompleteDAO {

	    private DBConnector db= new DBConnector();

		private Connection con = db.getConnection();




		/*カートテーブルを購入履歴に登録するメソッド
		 * 1.カートテーブルを取得
		 * 2.購入履歴に登録
		 */

		//取得

		public ArrayList<CartInfoDTO> getCartInfo(String userId) throws SQLException {


			CartInfoDTO dto=new CartInfoDTO();
			ArrayList<CartInfoDTO> cartList=new ArrayList<CartInfoDTO>();
			String sql= "SELECT * from cart_info wehere user_id=?";

			try {
                PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, userId);
				ResultSet rs=ps.executeQuery();

				if(rs.next()){

					dto.setUserId(rs.getString("user_id"));
					dto.setProduct_id(rs.getInt("product_id"));
					dto.setProductCount(rs.getInt("product_count"));
					dto.setPrice(rs.getInt("price"));
					dto.setUpdateDate(rs.getDate("update_date"));
					dto.setRegistDate(rs.getDate("regist_date"));

					cartList.add(dto);


				}

				}catch (SQLException e) {
				e.printStackTrace();

			} finally {
				con.close();

			}
			return cartList;


		}

		//登録

		public void setPurchseHistory(String userId, int productId, int count) throws SQLException{

			DBConnector db= new DBConnector();
			Connection con = db.getConnection();
			String sql="INSERT INTO purchase_history_info(user_id,product_id,product_count,update_date) VALUES(?,?,?,NOW())";

			try{
				PreparedStatement ps = con.prepareStatement(sql);
			    ps.setString(1,userId);
			    ps.setInt(2, productId);
			    ps.setInt(3, count);
			    ps.execute();

			} catch(SQLException e) {
				e.printStackTrace();
			}
			finally {
				con.close();

			}
		}
}
