package com.Service;

import com.bean.Employee;

public interface EmployeeService {

	void save(Employee employee);
	void update(Employee employee);
	void delete(Integer id);
	Employee findById(Integer id);


}
