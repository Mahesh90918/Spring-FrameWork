package com.HasA.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.HasA.bean.Address;
import com.HasA.bean.Employee;
import com.HasA.bean.Student;

public class EmployeeTest {
	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext("SpringHas-A.xml");
		Employee emp = (Employee) ac.getBean("employeebean");
		System.out.println(emp);

		Student stu = (Student) ac.getBean("studentbean");
		System.out.println(stu);

		Address ads = (Address) ac.getBean("address");
		System.out.println(ads);
		Address ads1 = (Address) ac.getBean("address1");
		System.out.println(ads1);

	}
}
