package com.Service;

import java.util.List;

import com.bean.Employee;

public interface EmployeeService {

	void save(Employee employee);

	void update(Employee employee);

	void delete(Integer id);

	Employee findById(Integer id);

	List<Employee> findbyAll();

}
