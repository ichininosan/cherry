package com.internousdev.cherry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.cherry.dto.CartInfoDTO;
import com.internousdev.cherry.util.DBConnector;
import com.opensymphony.xwork2.ActionSupport;

public class CartInfoDAO extends ActionSupport{

	DBConnector db = new DBConnector();
	Connection con = null;

	/**
	 * ログインユーザーの商品をカートに入れる(user_id)
	 * @param dto
	 * @return
	 * @throws SQLException
	 */
	public boolean putProductIntoCart(CartInfoDTO dto) throws SQLException{
		boolean result = false;
		int updateCount = 0;

		String sql = "INSERT INTO cart_info(user_id, product_id, product_count, insert_date)"
						+ "VALUES(?, ?, ?, NOW())";

		try{
			con = db.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getUserId());
			ps.setInt(2, dto.getProductId());
			ps.setInt(3, dto.getProductCount());
			updateCount = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		if(updateCount == 1){
			result = true;
		}
		return result;
	}

	/**
	 * 非ログインユーザーの商品をカートに入れる(temp_user_id)
	 * @param dto
	 * @return
	 * @throws SQLException
	 */
	public boolean putProductIntoCartOfGuestUser(CartInfoDTO dto) throws SQLException{
		boolean result = false;
		int updateCount = 0;

		String sql = "INSERT INTO cart_info(temp_user_id, product_id, product_count, insert_date)"
						+ "VALUES(?, ?, ?, NOW())";

		try{
			con = db.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getTempUserId());
			ps.setInt(2, dto.getProductId());
			ps.setInt(3, dto.getProductCount());
			updateCount = ps.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		if(updateCount == 1){
			result = true;
		}
		return result;
	}

	/**
	 * 指定したログインユーザーのカート情報をすべて引き出す
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<CartInfoDTO> showUserCartList(String userId) throws SQLException{
		ArrayList<CartInfoDTO> cartList = new ArrayList<>();

		String sql = "SELECT cart_info.product_id, pi.product_name, pi.product_name_kana, pi.image_file_name, pi.price, pi.release_company, pi.release_date, product_count"
						+ "FROM cart_info LEFT JOIN product_info as pi ON cart_info.product_id = pi.product_id"
						+ "WHERE user_id = ?";

		try{
			con = db.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				CartInfoDTO dto = new CartInfoDTO();
				dto.setProductId(rs.getInt("product_id"));
				dto.setProduct_name(rs.getString("product_name"));
				dto.setProduct_name_kana(rs.getString("product_name_kana"));
				dto.setImage_file_name(rs.getString("image_file_name"));
				dto.setPrice(rs.getInt("price"));
				dto.setRelease_company(rs.getString("release_company"));
				dto.setRelease_date(rs.getString("release_date"));
				dto.setProductCount(rs.getInt("product_count"));
				cartList.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return cartList;
	}

	/**
	 * 指定したログインユーザーのカート情報をすべて引き出す
	 * @param tempUserId
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<CartInfoDTO> showTempUserCartList(String tempUserId) throws SQLException{
		ArrayList<CartInfoDTO> cartList = new ArrayList<>();

		String sql = "SELECT cart_info.product_id, cart_info.product_count, pi.product_name, pi.product_name_kana, pi.image_file_name, pi.price, pi.release_company, pi.release_date"
						+ "FROM cart_info LEFT JOIN product_info as pi ON cart_info.product_id = pi.product_id"
						+ "WHERE temp_user_id = ?";

		try{
			con = db.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, tempUserId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				CartInfoDTO dto = new CartInfoDTO();
				dto.setProductId(rs.getInt("product_id"));
				dto.setProductCount(rs.getInt("product_count"));
				dto.setProduct_name(rs.getString("product_name"));
				dto.setProduct_name_kana(rs.getString("product_name_kana"));
				dto.setImage_file_name(rs.getString("image_file_name"));
				dto.setPrice(rs.getInt("price"));
				dto.setRelease_company(rs.getString("release_company"));
				dto.setRelease_date(rs.getString("release_date"));
				cartList.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return cartList;
	}

	/**
	 * ログインユーザーのカートの情報を取得
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<CartInfoDTO> aquireUserCartInfo(String userId) throws SQLException{
		Connection con = db.getConnection();
		ArrayList<CartInfoDTO> cartList = new ArrayList<>();

		String sql = "SELECT * FROM cart_info WHERE user_id = ?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				CartInfoDTO dto = new CartInfoDTO();
				dto.setProduct_id(rs.getInt("product_id"));
				dto.setProductCount(rs.getInt("product_count"));
				cartList.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return cartList;
	}

	/**
	 * ログインユーザーのカート内商品の購入予定個数を変更
	 * @param dto
	 * @return
	 * @throws SQLException
	 */
	public int updateUsersCount(CartInfoDTO dto) throws SQLException {
		int updateCount = 0;
		String sql = "UPDATE cart_info SET product_count = ? WHERE user_id = ?";

		try {
			con = db.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, dto.getProductCount());
			ps.setString(2, dto.getUserId());

			updateCount = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		return updateCount;
	}



	/**
	 * 非ログインユーザーのカート内商品の購入予定個数を変更
	 * @param dto
	 * @return
	 * @throws SQLException
	 */
	public int updateTempUsersCount(CartInfoDTO dto) throws SQLException {
		int updateCount = 0;
		String sql = "UPDATE cart_info SET count = ? WHERE temp_user_id = ?";

		try {
			con = db.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, dto.getProductCount());
			ps.setString(2, dto.getTempUserId());

			updateCount = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		return updateCount;
	}

}


























