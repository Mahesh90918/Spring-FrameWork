package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Employee;

public class EmployeedaoImpl implements EmployeeDao {

	DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Employee employee) {
		System.out.println("EmployeedaoImpl Save method....");
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			connection = dataSource.getConnection();
			ps = connection.prepareStatement("insert into empolyee values(?,?,?,?)");
			ps.setInt(1, employee.getId());
			ps.setString(2, employee.getName());
			ps.setDouble(3, employee.getSalary());
			ps.setString(4, employee.getEmail());

			ps.executeUpdate();
			System.out.println("Sucess");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//	 connection Test
//	public static void main(String[] args) throws SQLException {
//		ApplicationContext ac = new ClassPathXmlApplicationContext("Spring.xml");
//		DataSource ds=(DataSource) ac.getBean("dataSource_DBCP");
//		System.out.println(ds.getConnection());
//
//	}

}
