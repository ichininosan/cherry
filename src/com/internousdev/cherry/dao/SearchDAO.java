package com.internousdev.cherry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.cherry.dto.SearchDTO;
import com.internousdev.cherry.util.DBConnector;

public class SearchDAO {
	private DBConnector db=new DBConnector();
	private Connection con=db.getConnection();
	private ArrayList<SearchDTO> searchDTOList=new ArrayList<SearchDTO>();

	/*
	全ての商品を表示
	*/
	public ArrayList<SearchDTO> allProductInfo(){
		String sql="SELECT*FROM product_info";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				SearchDTO searchDTO=new SearchDTO();
				searchDTO.setId(rs.getInt("id"));
				searchDTO.setProductId(rs.getInt("product_id"));
				searchDTO.setProductName(rs.getString("product_name"));
				searchDTO.setProductNameKana(rs.getString("product_name_kana"));
				searchDTO.setProductDescription(rs.getString("product_description"));
				searchDTO.setCategoryId(rs.getInt("category_id"));
				searchDTO.setPrice(rs.getInt("price"));
				searchDTO.setImageFileName(rs.getString("image_file_name"));
				searchDTO.setReleaseDate(rs.getDate("release_date"));
				searchDTO.setReleaseCompany(rs.getString("release_company"));
				searchDTO.setStatus(rs.getShort("status"));
				searchDTO.setRegistDate(rs.getDate("regist_date"));
				searchDTO.setUpdateDate(rs.getDate("update_date"));
				searchDTOList.add(searchDTO);

			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return searchDTOList;

	}
	/*
	商品IDのみで検索
	*/
	public ArrayList<SearchDTO> ByPrductId(){
		String sql="SELECT*FROM product_info WHERE product_id=?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				SearchDTO serchDTO=new SearchDTO();
				serchDTO.setId(rs.getInt("id"));
				serchDTO.setProductId(rs.getInt("product_id"));
				serchDTO.setProductName(rs.getString("product_name"));
				serchDTO.setProductNameKana(rs.getString("product_name_kana"));
				serchDTO.setProductDescription(rs.getString("product_description"));
				serchDTO.setCategoryId(rs.getInt("category_id"));
				serchDTO.setPrice(rs.getInt("price"));
				serchDTO.setImageFileName(rs.getString("image_file_name"));
				serchDTO.setReleaseDate(rs.getDate("release_date"));
				serchDTO.setReleaseCompany(rs.getString("release_company"));
				serchDTO.setStatus(rs.getShort("status"));
				serchDTO.setRegistDate(rs.getDate("regist_date"));
				serchDTO.setUpdateDate(rs.getDate("update_date"));
				searchDTOList.add(serchDTO);

			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return searchDTOList;

	}
	/*
	検索ワードのみで検索
	*/

	public ArrayList<SearchDTO> BySerchWord(String serchWord){
		String sql ="SELECT*FROM product_info WHERE product_name LIKE \'%' ? \'%' ";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, serchWord);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				SearchDTO serchDTO=new SearchDTO();
				serchDTO.setId(rs.getInt("id"));
				serchDTO.setProductId(rs.getInt("product_id"));
				serchDTO.setProductName(rs.getString("product_name"));
				serchDTO.setProductNameKana(rs.getString("product_name_kana"));
				serchDTO.setProductDescription(rs.getString("product_description"));
				serchDTO.setCategoryId(rs.getInt("category_id"));
				serchDTO.setPrice(rs.getInt("price"));
				serchDTO.setImageFileName(rs.getString("image_file_name"));
				serchDTO.setReleaseDate(rs.getDate("release_date"));
				serchDTO.setReleaseCompany(rs.getString("release_company"));
				serchDTO.setStatus(rs.getShort("status"));
				serchDTO.setRegistDate(rs.getDate("regist_date"));
				serchDTO.setUpdateDate(rs.getDate("update_date"));

				searchDTOList.add(serchDTO);

			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return searchDTOList;

	}
	/*
	カテゴリのみで検索
	 */
	public ArrayList<SearchDTO> ByProductCategory(int categoryId){
		String sql="SELECT*FROM product_info WHERE category_id=?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,categoryId);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				SearchDTO serchDTO=new SearchDTO();
				serchDTO.setId(rs.getInt("id"));
				serchDTO.setProductId(rs.getInt("product_id"));
				serchDTO.setProductName(rs.getString("product_name"));
				serchDTO.setProductNameKana(rs.getString("product_name_kana"));
				serchDTO.setProductDescription(rs.getString("product_description"));
				serchDTO.setCategoryId(rs.getInt("category_id"));
				serchDTO.setPrice(rs.getInt("price"));
				serchDTO.setImageFileName(rs.getString("image_file_name"));
				serchDTO.setReleaseDate(rs.getDate("release_date"));
				serchDTO.setReleaseCompany(rs.getString("release_company"));
				serchDTO.setStatus(rs.getShort("status"));
				serchDTO.setRegistDate(rs.getDate("regist_date"));
				serchDTO.setUpdateDate(rs.getDate("update_date"));

				searchDTOList.add(serchDTO);

			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return searchDTOList;

	}
	/*
	カテゴリと検索ワード
	*/

	public ArrayList<SearchDTO> ByCategoryANDSerchWord(int categoryId,String serchWord){
		String sql="SELECT*FROM product_info WHERE product_name LIKE \'%' ? \'%' AND category_id=?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, serchWord);
			ps.setInt(2,categoryId);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				SearchDTO serchDTO=new SearchDTO();
				serchDTO.setId(rs.getInt("id"));
				serchDTO.setProductId(rs.getInt("product_id"));
				serchDTO.setProductName(rs.getString("product_name"));
				serchDTO.setProductNameKana(rs.getString("product_name_kana"));
				serchDTO.setProductDescription(rs.getString("product_description"));
				serchDTO.setCategoryId(rs.getInt("category_id"));
				serchDTO.setPrice(rs.getInt("price"));
				serchDTO.setImageFileName(rs.getString("image_file_name"));
				serchDTO.setReleaseDate(rs.getDate("release_date"));
				serchDTO.setReleaseCompany(rs.getString("release_company"));
				serchDTO.setStatus(rs.getShort("status"));
				serchDTO.setRegistDate(rs.getDate("regist_date"));
				serchDTO.setUpdateDate(rs.getDate("update_date"));

				searchDTOList.add(serchDTO);

			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return searchDTOList;

	}
	/*
	ひらがな検索
	*/
	public ArrayList<SearchDTO> BySerchWordKana(String serchWord){
		String sql="SELECT*FROM product_info WHERE product_name_kana LIKE \'%' ? \'%'";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, serchWord);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				SearchDTO serchDTO=new SearchDTO();
				serchDTO.setId(rs.getInt("id"));
				serchDTO.setProductId(rs.getInt("product_id"));
				serchDTO.setProductName(rs.getString("product_name"));
				serchDTO.setProductNameKana(rs.getString("product_name_kana"));
				serchDTO.setProductDescription(rs.getString("product_description"));
				serchDTO.setCategoryId(rs.getInt("category_id"));
				serchDTO.setPrice(rs.getInt("price"));
				serchDTO.setImageFileName(rs.getString("image_file_name"));
				serchDTO.setReleaseDate(rs.getDate("release_date"));
				serchDTO.setReleaseCompany(rs.getString("release_company"));
				serchDTO.setStatus(rs.getShort("status"));
				serchDTO.setRegistDate(rs.getDate("regist_date"));
				serchDTO.setUpdateDate(rs.getDate("update_date"));

				searchDTOList.add(serchDTO);

			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return searchDTOList;

	}
	public ArrayList<SearchDTO> ByCategoryANDSerchWordKana(int categoryId,String serchWord){
		String sql="SELECT*FROM product_info WHERE product_name_kana LIKE \'%' ? \'%' AND category_id=?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, serchWord);
			ps.setInt(2,categoryId);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				SearchDTO serchDTO=new SearchDTO();
				serchDTO.setId(rs.getInt("id"));
				serchDTO.setProductId(rs.getInt("product_id"));
				serchDTO.setProductName(rs.getString("product_name"));
				serchDTO.setProductNameKana(rs.getString("product_name_kana"));
				serchDTO.setProductDescription(rs.getString("product_description"));
				serchDTO.setCategoryId(rs.getInt("category_id"));
				serchDTO.setPrice(rs.getInt("price"));
				serchDTO.setImageFileName(rs.getString("image_file_name"));
				serchDTO.setReleaseDate(rs.getDate("release_date"));
				serchDTO.setReleaseCompany(rs.getString("release_company"));
				serchDTO.setStatus(rs.getShort("status"));
				serchDTO.setRegistDate(rs.getDate("regist_date"));
				serchDTO.setUpdateDate(rs.getDate("update_date"));

				searchDTOList.add(serchDTO);

			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return searchDTOList;

	}
	/*public ArrayList<SerchDTO> ByCategoryANDSerchWord(int categoryId,String serchWord){
		String sql="SELECT*FROM product_info WHERE product_name LIKE \'%' ? \'%' AND category_id=?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, serchWord);
			ps.setInt(2,categoryId);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				SerchDTO serchDTO=new SerchDTO();
				serchDTO.setId(rs.getInt("id"));
				serchDTO.setProductId(rs.getInt("product_id"));
				serchDTO.setProductName(rs.getString("product_name"));
				serchDTO.setProductNameKana(rs.getString("product_name_kana"));
				serchDTO.setProductDescription(rs.getString("product_description"));
				serchDTO.setCategoryId(rs.getInt("category_id"));
				serchDTO.setPrice(rs.getInt("price"));
				serchDTO.setImageFilePath(rs.getString("image_file_path"));
				serchDTO.setImageFileName(rs.getString("image_file_name"));
				serchDTO.setReleaseDate(rs.getDate("release_date"));
				serchDTO.setReleaseCompany(rs.getString("release_company"));
				serchDTO.setStatus(rs.getShort("status"));
				serchDTO.setRegistDate(rs.getDate("regist_date"));
				serchDTO.setUpdateDate(rs.getDate("update_date"));

				serchDTOList.add(serchDTO);

			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return serchDTOList;
*/
	/*}*/
	/*
	複数のキーワードで検索
	*/
	public ArrayList<SearchDTO> ByCategoryANDSerchWords(){
		String sql="SELECT*FROM product_info_transaction WHERE product_id=?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				SearchDTO serchDTO=new SearchDTO();
				serchDTO.setId(rs.getInt("id"));
				serchDTO.setProductId(rs.getInt("product_id"));
				serchDTO.setProductName(rs.getString("product_name"));
				serchDTO.setProductNameKana(rs.getString("product_name_kana"));
				serchDTO.setProductDescription(rs.getString("product_description"));
				serchDTO.setCategoryId(rs.getInt("category_id"));
				serchDTO.setPrice(rs.getInt("price"));
				serchDTO.setImageFileName(rs.getString("image_file_name"));
				serchDTO.setReleaseDate(rs.getDate("release_date"));
				serchDTO.setReleaseCompany(rs.getString("release_company"));
				serchDTO.setStatus(rs.getShort("status"));
				serchDTO.setRegistDate(rs.getDate("regist_date"));
				serchDTO.setUpdateDate(rs.getDate("update_date"));

				searchDTOList.add(serchDTO);

			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return searchDTOList;

	}











/*	public ArrayList<SerchDTO> getSerchInfo(int categoryId,String serchWord){
		String sql="SELECT*FROM item_info_transaction WHERE CONCAT('item_name','item_price') LIKE \'%' ? \'%'";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(parameterIndex, x);

			ResultSet rs=ps.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return serchDTO;

	}

	public ArrayList<SerchDTO> getSerchDTO() {
		return serchDTO;
	}

	public void setSerchDTO(ArrayList<SerchDTO> serchDTO) {
		this.serchDTO = serchDTO;
	}*/



}
