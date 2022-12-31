package com.test.RemaingMethods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.bean.Employee;

public class FindAllMethod {
//	Developer  cannot control this RowMapper
//	Developer control this ResultSetExtractor
	
	
	// one way
	public static List<Employee> findAll1() {
		List<Employee> list = new ArrayList<Employee>();
		ApplicationContext ac = new ClassPathXmlApplicationContext("Spring.xml");
		JdbcTemplate jdbc = (JdbcTemplate) ac.getBean("jdbc_temp");
		String query = "SELECT * FROM JDBCDEMO.EMPOLYEE";
//          with object reference   
		System.out.println("=============RowMapperExample================");
		return jdbc.query(query, new RowMapperExample());

	}

	// Second way
	public static List<Employee> findAll2() {
		List<Employee> list = new ArrayList<Employee>();
		ApplicationContext ac = new ClassPathXmlApplicationContext("Spring.xml");
		JdbcTemplate jdbc = (JdbcTemplate) ac.getBean("jdbc_temp");
		String query = "SELECT * FROM JDBCDEMO.EMPOLYEE";
//          with BeanPropertyRowMapper reference  
		System.out.println("============BeanPropertyRowMapper=================");
		return jdbc.query(query, new BeanPropertyRowMapper(Employee.class));
	}

	// Third way
	public static List<Employee> findAll3() {
		List<Employee> list = new ArrayList<Employee>();
		ApplicationContext ac = new ClassPathXmlApplicationContext("Spring.xml");
		JdbcTemplate jdbc = (JdbcTemplate) ac.getBean("jdbc_temp");
		String query = "SELECT * FROM JDBCDEMO.EMPOLYEE";
//              with Anonymous
		System.out.println("=========rowmapper=============");
		return jdbc.query(query, new RowMapper<Employee>() {

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

	// fourth way
	public static List<Employee> findAll4() {
		List<Employee> list = new ArrayList<Employee>();
		ApplicationContext ac = new ClassPathXmlApplicationContext("Spring.xml");
		JdbcTemplate jdbc = (JdbcTemplate) ac.getBean("jdbc_temp");
		String query = "SELECT * FROM JDBCDEMO.EMPOLYEE";
//	Developer control this ResultSetExtractor
//          with ResultSetExtractor reference  
		System.out.println("============ResultSetExtractor=================");
		return jdbc.query(query,
				new ResultSetExtractor<List<Employee>>() {

			@Override
			public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Employee> list4 = new ArrayList<Employee>();
				while (rs.next()) {
					Employee employee = new Employee();
					employee.setId(rs.getInt(1));
					employee.setName(rs.getString(2));
					employee.setSalary(rs.getDouble(3));
					employee.setEmail(rs.getString(4));
					list4.add(employee);
				}

				return list4;
			}
		});
	}

	public static void main(String[] args) {
		List<Employee> list = findAll4();
		for (Employee employee : list) {
			System.out.println(employee);
		}

	}
}
