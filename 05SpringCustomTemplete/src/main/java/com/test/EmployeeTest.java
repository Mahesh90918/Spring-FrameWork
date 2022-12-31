package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Employee;
import com.controller.EmployeeController;

public abstract class EmployeeTest {

	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext("Spring.xml");
		EmployeeController ec = (EmployeeController) ac.getBean("employeeController");

		Employee employee = new Employee(21, "siva", 50000.00, "siva@siva1");
//		 ec.save(employee);
		// ec.delete(21);
//		Employee emp=ec.findById(2);
//		System.out.println(emp);
		Employee emp1 = new Employee(2, "siva", 50000.00, "siva@siva12");
		ec.update(emp1);

	}

}
