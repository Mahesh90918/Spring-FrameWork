package com.test.RemaingMethods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bean.Employee;

public class FindAllExample {
	
	public static List<Employee> findbyid1(Integer id1, Integer id2) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("Spring.xml");
		JdbcTemplate jdbc = (JdbcTemplate) ac.getBean("jdbc_temp");
		String query = "select * from jdbcdemo.empolyee where id between ? and ?";
		return  jdbc.query(query, new Object[] { id1, id2 }, new ResultSetExtractor<List<Employee>>() {

			@Override
			public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Employee> list4 = new ArrayList();
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
		List<Employee> emp = findbyid1(1,10);
		for (Employee employee : emp) {
			System.out.println(employee);
		}
	}
}
