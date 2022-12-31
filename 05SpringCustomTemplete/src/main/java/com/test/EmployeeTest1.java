package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Employee;
import com.controller.EmployeeController;

public class EmployeeTest1 {
	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext("Spring.xml");
		EmployeeController ec = (EmployeeController) ac.getBean("employeeController");

		Employee employee = new Employee(19, "siva", 50000.00, "siva@siva1");
//		ec.save(employee);
		ec.delete(20);

	}
}
