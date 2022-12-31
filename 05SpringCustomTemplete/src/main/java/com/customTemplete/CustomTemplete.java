package com.customTemplete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomTemplete {
	@Autowired
	DataSource data;

	public void setData(DataSource data) {
		this.data = data;
	}

	/*
	 * is used to insert, update and delete records using PreparedStatement using
	 * given arguments.
	 */
	public void CustomUpdate(String Sqlquery, Object[] arr) {
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			connection = data.getConnection();
			ps = connection.prepareStatement(Sqlquery);
			for (int i = 0; i < arr.length; i++) {
				ps.setObject(i + 1, arr[i]);
			}
			ps.executeUpdate();
			System.out.println("custom Success");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
