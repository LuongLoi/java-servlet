package com.crud.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dbconnection.dbpool.HikariCPDataSource;

public class LoginDAO {
	public static boolean checkLogin(String user, String password) {
		boolean isValid = false;
		try {
			 Connection connection = HikariCPDataSource.getConnection();
			 String sql = "select * from users where email = ? and pass_word = ?";
			 PreparedStatement pre = connection.prepareStatement(sql);
			 pre.setString(1, user);
			 pre.setString(2, password);
			 ResultSet rs = pre.executeQuery();
			 if (rs.next()) {
				 isValid = true;
			 } 
		} catch(Exception e) {
			e.printStackTrace();
		}
		return isValid;
	}
	

}
