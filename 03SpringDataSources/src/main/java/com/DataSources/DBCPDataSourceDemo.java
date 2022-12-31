package com.DataSources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class DBCPDataSourceDemo {
	// Connection pooling
	// DataBase Connection pooling
	public static void main(String[] args) {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost:3306/jdbcdemo");
		bds.setUsername("root");
		bds.setPassword("root");
		Connection connection = null;
		try {
			connection = bds.getConnection();
			System.out.println("DBCPDataSource :" + connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bds.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
