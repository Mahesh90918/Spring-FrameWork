package com.test;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Employee;
import com.controller.EmployeeController;

public abstract class EmployeeTest {
	static Logger log = LoggerFactory.getLogger(EmployeeTest.class);

	public static void main(String[] args) {

		log.info("EMPLOYEETEST STARTING............");
		ApplicationContext ac = new ClassPathXmlApplicationContext("Spring.xml");
		EmployeeController ec = (EmployeeController) ac.getBean("employeeController");
		Employee employee = new Employee(5, "shankar", 2345, "siva@gfadsf");
		log.info("EMPLOYEETEST SAVE STARTING...........");
		ec.save(employee);
		log.info("EMPLOYEETEST UPDATE STARTING..........");
		ec.update(employee);

		log.info("EMPLOYEETEST FINDALL STARTING..........");
//		ec.findbyAll().forEach(t -> System.out.println(t));
		List<Employee> list = ec.findbyAll();
		log.info("EMPLOYEETEST FINDBYID STARTING........{}", list);
		Employee find_ID = ec.findById(5);
		System.out.println(find_ID);

		log.info("EMPLOYEETEST DELETE STARTING..........");
//		ec.delete(3);

		log.info("EMPLOYEETEST ENDING........{}", find_ID);
	}

}
