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

	/*
	 * カート情報取得
	 * @param user_id
	 * @param product_id
	 * @return
	 * @throws SQLExcception
	 */

	public ArrayList<CartInfoDTO> setCartInfo(String user_Id, String product_id) throws SQLException {
		ArrayList<CartInfoDTO> cartInfoDTO = new ArrayList<CartInfoDTO>();

	String sql="SELECT ci.id,ci.user_id, ci.product_id, ci.product_count, ci.price,ci.regist.date, ci.update_date FROM cart_info  ci RIGHT JOIN purchase-history-info phi ON ci.user_id=? AND product_id=?ORDER BY insert_date DESC";

	try{
		PreparedStatment ps=con.prepareStatement(sql);
		ps.setString(1,user_id);
		ps.setString(2,product_id);
		ResultSet rs=ps.executeQuery();

		while(rs.next()){
			ProductInfoDTO pidto=new ProductInfoDTO();
			pidto.setId(rs.getString("id"));
			pidto.setProductId(rs.getString("product_id"));
			pidto.setProductCount(rs.getString(""))
		}

	}catch{
		(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
	}
}