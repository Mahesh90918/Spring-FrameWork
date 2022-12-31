package com.Service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.bean.Employee;
import com.dao.EmployeeDao;
import com.dao.EmployeedaoImpl;
//we can use this annotation in Service Layer

@Service("empServImpl")
public class EmployeeServiceImpl implements EmployeeService {
// normal way
//	EmployeeDao dao = new EmployeedaoImpl();
	// this object creating Spring
	
	@Autowired
	EmployeeDao dao;


	@Override
	public void save(Employee employee) {
		System.out.println("EmployeeServiceImpl Save Method");
		dao.save(employee);
	}

}
