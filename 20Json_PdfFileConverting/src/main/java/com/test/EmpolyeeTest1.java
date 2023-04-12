package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bean.Employee;
import com.controller.EmployeeController;
import com.hibernateConfig.HibernateConfiguration;

public class EmpolyeeTest1 {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(HibernateConfiguration.class);
		EmployeeController ec = (EmployeeController) ac.getBean("employeeController");
		Employee employee = new Employee(5, "shankar", 2345, "siva@gfadsf");
		ec.save(employee);
		System.out.println(ac);
		ec.findbyAll().forEach(System.out::println);
	}
}
