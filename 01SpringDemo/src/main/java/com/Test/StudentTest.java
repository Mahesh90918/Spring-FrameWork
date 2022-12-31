package com.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Employee;
import com.bean.Employee1;
import com.bean.Student;

public class StudentTest {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("Spring.xml");
		// only setters
		// Student Object Creation
		Student ss = (Student) ac.getBean("studentdemo");// id name of bean
		System.out.println(ss);
		// Employee Object Creation
		// Parameterized constructor
		Employee emp = (Employee) ac.getBean("employeedemo");
		System.out.println(emp);
		// default constructor
		Employee1 emp1 = (Employee1) ac.getBean("employee1demo");
		System.out.println(emp1);

//		Resource resource = new ClassPathResource("Spring.xml");
//		BeanFactory factory = new XmlBeanFactory(resource);
//		Employee2 emp2 = (Employee2) factory.getBean("employee2demo");
//		System.out.println(emp2);
	}
}
