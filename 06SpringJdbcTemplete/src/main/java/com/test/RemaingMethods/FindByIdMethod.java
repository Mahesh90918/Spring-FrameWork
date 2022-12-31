package com.test.RemaingMethods;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.bean.Employee;

public class FindByIdMethod {
	// one way
	public static Employee findbyid1(Integer id) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("Spring.xml");
		JdbcTemplate jdbc = (JdbcTemplate) ac.getBean("jdbc_temp");
		String query = "select * from jdbcdemo.empolyee where id=?";
		return (Employee) jdbc.queryForObject(query, new Object[] { id }, new RowMapperExample());

	}

	// Second way
	public static Employee findbyid2(Integer id) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("Spring.xml");
		JdbcTemplate jdbc = (JdbcTemplate) ac.getBean("jdbc_temp");
		String query = "select * from jdbcdemo.empolyee where id=?";
		Employee emp = (Employee) jdbc.queryForObject("select * from jdbcdemo.empolyee where id=?", new Object[] { id },
				new RowMapperExample());
		return emp;
	}// Third way

	public static Employee findbyid3(Integer id1) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("Spring.xml");
		JdbcTemplate jdbc = (JdbcTemplate) ac.getBean("jdbc_temp");
		String query = "select * from jdbcdemo.empolyee where id= ?";
		return (Employee) jdbc.queryForObject(query, new Object[] { id1 }, new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee employee = new Employee();
				employee.setId(rs.getInt(1));
				employee.setName(rs.getString(2));
				employee.setSalary(rs.getDouble(3));
				employee.setEmail(rs.getString(4));
				return employee;
			}
		});
	}

	public static Employee findbyid4(Integer id) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("Spring.xml");
		JdbcTemplate jdbc = (JdbcTemplate) ac.getBean("jdbc_temp");
		String query = "select * from jdbcdemo.empolyee where id=?";
		return (Employee) jdbc.query(query, new Object[] { id }, new ResultSetExtractor<Employee>() {

			@Override
			public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
				Employee employee = new Employee();
				while (rs.next()) {
					employee.setId(rs.getInt(1));
					employee.setName(rs.getString(2));
					employee.setSalary(rs.getDouble(3));
					employee.setEmail(rs.getString(4));
				}

				return employee;
			}
		});
	}

	public static void main(String[] args) {
		Employee emp = findbyid3(1);
		System.out.println(emp);
	}
}
