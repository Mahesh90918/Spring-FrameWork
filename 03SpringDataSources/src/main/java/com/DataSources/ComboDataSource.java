package com.DataSources;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ComboDataSource {
	public static void main(String[] args) {
		ComboPooledDataSource combo = new ComboPooledDataSource();
		combo.setDataSourceName("com.mysql.cj.jdbc.Driver");
		combo.setJdbcUrl("jdbc:mysql://localhost:3306/jdbcdemo");
		combo.setUser("root");
		combo.setPassword("root");
		try {
			Connection con = combo.getConnection();
			System.out.println("ComboDataSource :" + con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
