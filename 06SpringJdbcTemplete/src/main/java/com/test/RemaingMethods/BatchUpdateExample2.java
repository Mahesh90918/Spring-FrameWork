package com.test.RemaingMethods;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bean.Employee;

public class BatchUpdateExample2 {
	public static List<Employee> batchUpdate1(List<Employee> employee) {

		ApplicationContext ac = new ClassPathXmlApplicationContext("Spring.xml");
		JdbcTemplate jdbc = (JdbcTemplate) ac.getBean("jdbc_temp");
		String Sql = "INSERT INTO EMPOLYEE VALUES(?,?,?,?)";
		jdbc.batchUpdate(Sql, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setInt(1, employee.get(i).getId());
				ps.setString(2, employee.get(i).getName());
				ps.setDouble(3, employee.get(i).getSalary());
				ps.setString(4, employee.get(i).getEmail());
			}

			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return employee.size();
			}
		});
		return employee;

	}

	public static List<Employee> batchUpdate2(List<Employee> employee) {

		ApplicationContext ac = new ClassPathXmlApplicationContext("Spring.xml");
		JdbcTemplate jdbc = (JdbcTemplate) ac.getBean("jdbc_temp");
		String Sql = "update empolyee set name=?,salary=?,email=? where id=?";
		jdbc.batchUpdate(Sql, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setString(1, employee.get(i).getName());
				ps.setDouble(2, employee.get(i).getSalary());
				ps.setString(3, employee.get(i).getEmail());
				ps.setInt(4, employee.get(i).getId());
			}

			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return employee.size();
			}
		});
		return employee;

	}

	public static void main(String[] args) {
		List<Employee> emp = new ArrayList<Employee>();
		emp.add(new Employee(10, "Siva", 25000, "kdsfjh@kjhdsk"));
		emp.add(new Employee(11, "shankar", 30000, "samba@kjhdsk"));
		emp.add(new Employee(12, "samba", 40000, "kdsfjh@kjhdsk"));
		emp.add(new Employee(13, "Siva", 50000, "kdsfjh@kjhdsk"));
		List<Employee> list = batchUpdate2(emp);
		System.out.println(list);
	}

}
