package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("del")
public class DeletequerySarada {

	@Autowired
	DataSource ds;

	public void delete(int id) {

		Connection connection = null;
		PreparedStatement ps = null;

		try {
			connection = ds.getConnection();
			ps = connection.prepareStatement("delete from empolyee where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			System.out.println("Sucess");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("Spring.xml");
		DeletequerySarada ds = (DeletequerySarada) ac.getBean("del");
		ds.delete(17);

	}
}
