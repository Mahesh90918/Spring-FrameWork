package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Service.EmployeeService;
import com.bean.Employee;

@RestController
//@RestController added spring 4.0
public class EmployeeController {

	// @RestController = @ResponseBody + @Controller
	// it returns HTTP response as a JSON or XML

	@Autowired
	EmployeeService employeeService;

//	@RequestMapping(value = "/save", method = RequestMethod.POST)

	// alternative Way @RequestMapping TO @PostMapping

	@PostMapping(value = "/save")
	public Employee saveEmp(@RequestBody Employee employee) {
		System.out.println("Employee : " + employee);
		employeeService.save(employee);
		return employee;
	}

//	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	@PutMapping(value = "/update")
	public Employee updateEmpolyee(@RequestBody Employee employee) {
		employeeService.update(employee);
		return employee;
	}

//	@RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)

	@GetMapping(value = "/findById/{id}")
	public Employee findById(@PathVariable Integer id) {
		Employee employee = employeeService.findById(id);
		return employee;
	}

//	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)

	@DeleteMapping(value = "/delete/{id}")
	public String deleteEmp(@PathVariable Integer id) {

		employeeService.delete(id);
		return "Delete Successfully";
	}

//	@RequestMapping(value = "/findAll", method = RequestMethod.GET)

	@GetMapping(value = "/findAll")
	public List<Employee> findAll() {
		return employeeService.findbyAll();
	}

}
