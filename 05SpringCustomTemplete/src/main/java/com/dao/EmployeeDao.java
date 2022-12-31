package com.dao;

import com.bean.Employee;

public interface EmployeeDao {

	void save(Employee employee);
	void update(Employee employee);
	void delete(Integer id);
	Employee findById(Integer id);

}
