package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Employee;
import com.controller.EmployeeController;

public abstract class EmployeeTest {

	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext("Spring.xml");
		EmployeeController ec = (EmployeeController) ac.getBean("empController");

		Employee employee = new Employee(18, "siva", 50000.00, "siva@siva");
		ec.save(employee);
	}

}
