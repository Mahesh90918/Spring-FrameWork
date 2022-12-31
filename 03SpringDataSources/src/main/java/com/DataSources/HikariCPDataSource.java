package com.DataSources;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

public class HikariCPDataSource {
	public static void main(String[] args) {
		HikariDataSource hikari = new HikariDataSource();
		hikari.setDriverClassName("com.mysql.cj.jdbc.Driver");
		hikari.setJdbcUrl("jdbc:mysql://localhost:3306/jdbcdemo");
		hikari.setUsername("root");
		hikari.setPassword("root");
		try {
			Connection connection = hikari.getConnection();
			System.out.println("HikariCPDataSource :" + connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
