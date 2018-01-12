package com.internousdev.cherry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.cherry.dto.PurchaseHistoryDTO;
import com.internousdev.cherry.util.DBConnector;



public class PurchaseHistoryDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();

/*
 * 購入履歴表示メソッド
 *
 */


	public ArrayList<PurchaseHistoryDTO> getPurchaseHistory(String user_id) throws SQLException{
		ArrayList<PurchaseHistoryDTO> purchaseHistoryDTOList = new ArrayList<PurchaseHistoryDTO>();

		/*
		 * piはproduct_infoの略
		 * phiはpurchase_history_infoの略
		 */
		String sql = "SELECT phi.id, pi.product_name, pi.product_name_kana, pi.image_file_name,  phi.price, pi.release_company, pi.release_date  FROM purchase_history_info phi LEFT JOIN product_info pi ON phi.product_id = pi.product_id  WHERE phi.user_id = ?";


		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "a");
						//user_id

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				PurchaseHistoryDTO dto = new PurchaseHistoryDTO();
				dto.setId(rs.getInt("id"));
				dto.setProductName(rs.getString("product_name"));
				dto.setProductNameKana(rs.getString("product_name_kana"));
				dto.setPrice(rs.getInt("price"));
				dto.setReleaseCompany(rs.getString("release_company"));
				dto.setReleaseDate(rs.getString("release_date"));
				dto.setProductImage(rs.getString("image_file_name"));

				purchaseHistoryDTOList.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			con.close();
		}
		return purchaseHistoryDTOList;
	}

	/*
	 * 購入履歴削除メソッド
	 */
	public int deleteHistory(String user_id) throws SQLException{
		String sql = "DELETE FROM purchase_history_info where user_id = ?";

		PreparedStatement ps;
		int result = 0;
		try{
			ps = con.prepareStatement(sql);
			ps.setString(1, "a");
			//user_id

			result = ps.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		} finally {
			con.close();
		}
		return result;

	}



	/*
	 * 履歴個別削除メソッド
	 */
	public int deletePart(int id) throws SQLException{
		String sql = "DELETE  FROM purchase_history_info where id = ?";
		PreparedStatement ps;
		int result = 0;
		try{
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);


			result = ps.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		} finally {
			con.close();
		}
		return result;

}
	}























