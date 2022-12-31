package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Employee;
import com.controller.EmployeeController;

public abstract class EmployeeTest {

	public static void main(String[] args) {
//		EmployeeController emp = new EmployeeController();
//		Employee employee = new Employee();
//		emp.save(employee);
//		System.out.println(emp);
//		System.out.println("=======================");
//		ApplicationContext ac = new ClassPathXmlApplicationContext("Spring.xml");
//		EmployeeController ec = (EmployeeController) ac.getBean("empController");
//		Employee employee = new Employee();
//		ec.save(employee);
//		System.out.println(ec);

		// insert data into dataBase
		ApplicationContext ac = new ClassPathXmlApplicationContext("Spring.xml");
		EmployeeController ec = (EmployeeController) ac.getBean("empController");

		Employee employee = new Employee(8, "siva", 50000.00, "siva@siva");
		ec.save(employee);
	}

}
