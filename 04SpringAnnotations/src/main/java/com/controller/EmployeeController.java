package com.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import com.Service.EmployeeService;
import com.Service.EmployeeServiceImpl;
import com.bean.Employee;


//we can use this annotation in Controller Layer

@Controller("empController")

public class EmployeeController {

	@Autowired
	EmployeeService empService;


	public void save(Employee employee) {
		System.out.println("EmployeeController Save method");
		empService.save(employee);
	}
}
