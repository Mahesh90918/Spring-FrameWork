package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Service.EmployeeService;
import com.bean.Employee;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/save", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	public @ResponseBody Employee saveEmp(@RequestBody Employee employee) {
		System.out.println("Employee : " + employee);
		employeeService.save(employee);
		return employee;
	}

	@RequestMapping(value = "/update", produces = "application/json", consumes = "application/json", method = RequestMethod.PUT)
	public @ResponseBody Employee updateEmpolyee(@RequestBody Employee employee) {
		employeeService.update(employee);
		return employee;
	}

	@RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
	public @ResponseBody Employee findById(@PathVariable Integer id) {
		Employee employee = employeeService.findById(id);
		return employee;
	}

	// by default it is get method
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public @ResponseBody String deleteEmp(@PathVariable Integer id) {

		employeeService.delete(id);
		return "Delete Successfully";
	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Employee> findAll() {
		return employeeService.findbyAll();
	}

}
