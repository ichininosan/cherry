package com.internousdev.cherry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.cherry.util.DBConnector;
import com.internousdev.cherry.util.DateUtil;
public class UserCreateCompleteDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private DateUtil dateUtil = new DateUtil();
	private String sql = "INSERT INTO login_user_transaction(login_id, login_pass, user_name,insert_date) VALUES(?,?,?,?)";
	public void createUser( String user_id,String password, String family_name, String first_name, String family_name_kana, String first_name_kana,String sex, String email)throws SQLException{
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,user_id);
			preparedStatement.setString(2,password);
			preparedStatement.setString(3,family_name);
			preparedStatement.setString(4,first_name);
			preparedStatement.setString(5,family_name_kana);
			preparedStatement.setString(6,first_name_kana);
			preparedStatement.setString(7,sex);
			preparedStatement.setString(8,email);

			preparedStatement.setString(9,dateUtil.getDate());

			preparedStatement.executeQuery();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
	}
	public void createUser(String string, String string2, String string3, String string4, String string5,
			String string6, String string7, String string8, String string9) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
