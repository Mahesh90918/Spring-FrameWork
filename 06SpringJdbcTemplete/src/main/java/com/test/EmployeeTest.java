package com.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.controller.EmployeeController;

public abstract class EmployeeTest {
	static Logger log = LoggerFactory.getLogger(EmployeeTest.class);

	public static void main(String[] args) {
		log.info(" EmployeeTest bean Start");
		ApplicationContext ac = new ClassPathXmlApplicationContext("Spring.xml");
		EmployeeController ec = (EmployeeController) ac.getBean("employeeController");

//		Employee employee = new Employee(22, "siva", 50000.00, "siva@siva1");
//		ec.save(employee);

//		Employee emp1 = new Employee(2, "sivaaa", 50000.00, "siva@siva12");
//		ec.update(emp1);

		 ec.findbyAll().forEach(System.out::println);

		// System.out.println(emp);

		log.info(" bean {}", ec);
		log.info(" bean {}", ac);
	}

}
