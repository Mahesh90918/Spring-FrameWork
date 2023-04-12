package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.Service.EmployeeService;
import com.bean.Employee;

//we can use this annotation in Controller Layer

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	public void save(Employee employee) {
		System.out.println("EmployeeController Save method");
		empService.save(employee);
	}

	public void update(Employee employee) {
		System.out.println("EmployeeController update method");
		empService.update(employee);
	}

	public void delete(Integer id) {
		System.out.println("EmployeeController delete method");
		empService.delete(id);
	}

	public Employee findById(Integer id) {
		System.out.println("EmployeeController findById method");
		return empService.findById(id);

	}

	public List<Employee> findbyAll() {
		return empService.findbyAll();
	}

	
}
