package com.internousdev.cherry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.cherry.util.DBConnector;


public class ResetPasswordCompleteDAO  {

	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();


	private String sql = "INSERT INTO login_user_transaction (login_id, login_pass, login_passc, insert_date) VALUES(?, ? ,?, ?)";

	public void resetPassword(String loginUserId, String loginUserPassword) throws SQLException {

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginUserPassword);

			preparedStatement.execute();

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}
}
