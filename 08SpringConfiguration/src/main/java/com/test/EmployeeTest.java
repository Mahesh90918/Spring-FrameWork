package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.controller.EmployeeController;
import com.springConfig.SpringConfig;

public abstract class EmployeeTest {

	public static void main(String[] args) {

//		ApplicationContext ac = new ClassPathXmlApplicationContext("Spring.xml");
		ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);

		EmployeeController ec = (EmployeeController) ac.getBean("employeeController");

		ec.findbyAll().forEach(System.out::println);
		System.out.println(ec.findById(1));
	}

}
