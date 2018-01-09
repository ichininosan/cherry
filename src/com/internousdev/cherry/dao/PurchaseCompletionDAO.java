package com.internousdev.cherry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.cherry.util.DBConnector;
import com.internousdev.cherry.util.DateUtil;;



public class PurchaseCompletionDAO {

	private DBConnector db=new DBConnector();
	private Connection con=db.getConnection();
	private DateUtil dateUtil=new DateUtil();

	private String sql="INSERT INTO user_buy_transaction(item_transaction_id, total_count, user_master_id, pay, insert_date)VALUES(?,?,?,?,?,?)";

	/**
	 * 商品購入情報登録メソッド
	 * @param item_transaction_id
	 * @param user_master_id
	 * @param total_price
	 * @param total_count
	 * @param pay
	 * @param SQLException
	 */
	public void buyItemInfo(String item_transaction_id,String user_master_id,String total_price, String total_count, String pay)throws SQLException{

	try{
		PreparedStatement ps=con.prepareStatement(sql);

		ps.setString(1,item_transaction_id);
		ps.setString(2,total_price);
		ps.setString(3,total_count);
		ps.setString(4,user_master_id);
		ps.setString(5,pay);
		ps.setString(6,dateUtil.getDate());

		ps.executeQuery();

	}catch(Exception e){
		e.printStackTrace();
	}finally{
		con.close();
	}

}

	/**
	 * 商品履歴削除
	 *
	 * @param item_transaction_id
	 * @param user_master_id
	 * @return
	 * @throws SQLException
	 */
	public int buyItemHistoryDelete(String item_transaction_id, String user_master_id) throws SQLException {

		String sql = "DELETE FROM user_buy_item_transaction where item_transaction_id  = ? AND user_master_id  = ?";

		PreparedStatement ps;
		int result =0;
		try {
			ps =con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, user_master_id);

			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		return result;
	}
}
