package com.Service;

import com.bean.Employee;
import com.dao.EmployeeDao;
import com.dao.EmployeedaoImpl;

public class EmployeeServiceImpl implements EmployeeService {
// normal way
//	EmployeeDao dao = new EmployeedaoImpl();
	// this object creating Spring
	EmployeeDao dao;

	public EmployeeServiceImpl(EmployeeDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public void save(Employee employee) {
		System.out.println("EmployeeServiceImpl Save Method");
		dao.save(employee);
	}

}
