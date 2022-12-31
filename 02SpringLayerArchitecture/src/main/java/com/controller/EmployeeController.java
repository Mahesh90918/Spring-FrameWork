package com.controller;

import com.Service.EmployeeService;
import com.Service.EmployeeServiceImpl;
import com.bean.Employee;

public class EmployeeController {
// normal way
//	EmployeeService empService=new EmployeeServiceImpl();
	
	EmployeeService empService;

	public EmployeeController(EmployeeService empService) {
		super();
		this.empService = empService;
	}

	public void save(Employee employee) {
		System.out.println("EmployeeController Save method");
		empService.save(employee);
	}
}
