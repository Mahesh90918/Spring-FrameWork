package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Queries.EmployeeQueries;
import com.bean.Employee;
import com.customTemplete.CustomTemplete;

@Repository
public class EmployeeCustomTempleteDaoImpl implements EmployeeDao {

	@Autowired
	CustomTemplete custom;

	@Override
	public void save(Employee employee) {
		System.out.println("EmployeeCustomTempleteDaoImpl save");
		custom.CustomUpdate(EmployeeQueries.INSERT_QUERY,
				new Object[] { employee.getId(), employee.getName(), employee.getSalary(), employee.getEmail() });

	}

	@Override
	public void update(Employee empolyee) {
		System.out.println("EmployeeCustomTempleteDaoImpl update");
		custom.CustomUpdate(EmployeeQueries.UPDATE,
				new Object[] { empolyee.getName(), empolyee.getSalary(), empolyee.getEmail(), empolyee.getId() });

	}

	@Override
	public void delete(Integer id) {
		Employee emp = new Employee();
		emp.setId(id);
		System.out.println("EmployeeCustomTempleteDaoImpl delete");
		custom.CustomUpdate(EmployeeQueries.DELETE_BY_ID, new Object[] { emp.getId() });

	}

	@Override
	public Employee findById(Integer id) {
		return null;
		//return (Employee) custom.queryForObject(EmployeeQueries.FIND_BY_ID, new Object[] { id }, new BeanPropertyRowMapper(Employee.class));
	}

}
