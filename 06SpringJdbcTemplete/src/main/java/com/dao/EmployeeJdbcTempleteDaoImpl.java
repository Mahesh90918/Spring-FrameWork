package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.Queries.EmployeeQueries;
import com.bean.Employee;

@Service
public class EmployeeJdbcTempleteDaoImpl implements EmployeeDao {
	@Autowired
	JdbcTemplate jdbctem;

	@Override
	public void save(Employee employee) {

//		 Statement SQl Query
//		jdbctem.update("insert into empolyee values('" + employee.getId() + "','" + employee.getName() + "','"
//				+ employee.getSalary() + "','" + employee.getEmail() + "')");

//		 prepareStatement SQl Query
		System.out.println("EmployeeJdbcTempleteDaoImpl save ...");
		jdbctem.update(EmployeeQueries.INSERT_QUERY,
				new Object[] { employee.getId(), employee.getName(), employee.getSalary(), employee.getEmail() });

	}

	@Override
	public void update(Employee empolyee) {
		System.out.println("EmployeeCustomTempleteDaoImpl update");
		jdbctem.update(EmployeeQueries.UPDATE,
				new Object[] { empolyee.getName(), empolyee.getSalary(), empolyee.getEmail(), empolyee.getId() });

	}

	@Override
	public void delete(Integer id) {
		Employee emp = new Employee();
		emp.setId(id);
		System.out.println("EmployeeCustomTempleteDaoImpl delete");
		jdbctem.update(EmployeeQueries.DELETE_BY_ID, new Object[] { emp.getId() });

	}

	@Override
	public Employee findById(Integer id) {

		return (Employee) jdbctem.queryForObject(EmployeeQueries.FIND_BY_ID, new Object[] { id },
				new BeanPropertyRowMapper(Employee.class));

	}

	@Override
	public List<Employee> findbyAll() {

		return jdbctem.query(EmployeeQueries.FIND_ALL, new BeanPropertyRowMapper(Employee.class));
	}

}
