package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.Queries.EmployeeQueries;
import com.bean.Employee;

// we can use this annotation in Dao Layer

@Repository
public class EmployeedaoImpl implements EmployeeDao {
	// we can use AutoWire annotation in setters,properties,constructors
	@Autowired
	DataSource dataSource;

	@Override
	public void save(Employee employee) {
		System.out.println("EmployeedaoImpl Save method....");
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			connection = dataSource.getConnection();
			ps = connection.prepareStatement(EmployeeQueries.INSERT_QUERY);
			ps.setInt(1, employee.getId());
			ps.setString(2, employee.getName());
			ps.setDouble(3, employee.getSalary());
			ps.setString(4, employee.getEmail());

			ps.executeUpdate();
			System.out.println(" Save Sucess");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

	@Override
	public void update(Employee employee) {
		System.out.println("EmployeedaoImpl Update method....");
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			connection = dataSource.getConnection();
			ps = connection.prepareStatement(EmployeeQueries.UPDATE);
			ps.setString(1, employee.getName());
			ps.setDouble(2, employee.getSalary());
			ps.setString(3, employee.getEmail());
			ps.setInt(4, employee.getId());

			ps.executeUpdate();
			System.out.println("Update Sucess");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

	@Override
	public void delete(Integer id) {
		System.out.println("EmployeedaoImpl delete method....");
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			connection = dataSource.getConnection();
			ps = connection.prepareStatement(EmployeeQueries.DELETE_BY_ID);
			ps.setInt(1, id);

			ps.executeUpdate();
			System.out.println("delete Sucess");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

	@Override
	public Employee findById(Integer id) {
		System.out.println("EmployeedaoImpl findby id method....");
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connection = dataSource.getConnection();
			ps = connection.prepareStatement(EmployeeQueries.FIND_BY_ID);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			Employee emp = new Employee();
			while (rs.next()) {
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setSalary(rs.getDouble(3));
				emp.setEmail(rs.getString(4));
			}
			return emp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		return null;

	}

//	 connection Test
	public static void main(String[] args) throws SQLException {
		ApplicationContext ac = new ClassPathXmlApplicationContext("Spring.xml");
//		DataSource ds=(DataSource) ac.getBean("dataSource_DBCP");
//		System.out.println(ds.getConnection());

		EmployeedaoImpl e = (EmployeedaoImpl) ac.getBean(EmployeedaoImpl.class);
		Employee emp = e.findById(2);
		System.out.println(emp);
	}

	@Override
	public List<Employee> findbyAll() {
		System.out.println("EMPLOYEEDAOIMPL FINDBY ALL METHOD....");
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connection = dataSource.getConnection();
			ps = connection.prepareStatement(EmployeeQueries.FIND_ALL);
			rs = ps.executeQuery();
			List<Employee> list = new ArrayList<>();
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setSalary(rs.getDouble(3));
				emp.setEmail(rs.getString(4));
				list.add(emp);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		return null;
	}

}
