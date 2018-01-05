package com.internousdev.cherry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.cherry.dto.SerchDTO;
import com.internousdev.cherry.util.DBConnector;

public class SerchDAO {
	private DBConnector db=new DBConnector();
	private Connection con=db.getConnection();
	private SerchDTO serchDTO=new SerchDTO();

	public SerchDTO getSerchInfo(String serchWord){
		String sql="";
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

	public SerchDTO getSerchDTO() {
		return serchDTO;
	}

	public void setSerchDTO(SerchDTO serchDTO) {
		this.serchDTO = serchDTO;
	}



}
