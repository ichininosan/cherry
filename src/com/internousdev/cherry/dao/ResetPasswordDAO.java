package com.internousdev.cherry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.cherry.dto.ResetPasswordDTO;
import com.internousdev.cherry.util.DBConnector;

public class ResetPasswordDAO  {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	private ResetPasswordDTO resetPasswordDTO = new ResetPasswordDTO();


	/*userIdをDBから探すメソッド*/
	public boolean getUserId(String userId){

	String sql="SELECT * FROM user_info where user_id=?";

		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);

			ResultSet resultSet=preparedStatement.executeQuery();

		if(resultSet.next()){
			resetPasswordDTO.setuserId(resultSet.getString("userId"));
			return true;
		}

		}catch(Exception e){
			e.printStackTrace();
		}
			return false;
		}

	/*ユーザーIDを元にして新しいパスワードをDBにセットするメソッド*/
	public boolean updatePassword(String password,String userId){

	String sql="UPDATE user_info SET password =? where user_id= ?";

		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, password);
			preparedStatement.setString(2,userId);

			preparedStatement.executeUpdate();
			return true;

		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}


	public void setResetPasswordDTO(ResetPasswordDTO resetPasswordDTO) {
		this.resetPasswordDTO = resetPasswordDTO;
	}

	public ResetPasswordDTO getResetPasswordDTO() {
		return resetPasswordDTO;
		}
}

