package com.dbconnection.dbpool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDBcrud {
	public static void main(String[] args) {
		String sqlSelect = "SELECT * FROM user";
        try {
        		Connection conn = HikariCPDataSource.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sqlSelect);
                while (rs.next()) {  
                    int id = rs.getInt("id");
                    String address = rs.getString("address");
                    String username = rs.getString("full_name");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");

                    System.out.println(id + " - " + username + " - " + phone + " - " + email + " - " + address);
                }
        } catch(Exception e) {
        	e.printStackTrace();
        }
	}
}
