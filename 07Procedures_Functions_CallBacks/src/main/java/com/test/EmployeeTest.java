package com.test;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Employee;
import com.dao.EmployeeJdbcTempleteDaoImpl;

public class EmployeeTest {
	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext("Spring.xml");

		EmployeeJdbcTempleteDaoImpl em = ac.getBean(EmployeeJdbcTempleteDaoImpl.class);

		Map<String, Integer> map = em.execute(14, 45);
		System.out.println(map);
		System.out.println("=========================");
		Employee empp = em.getEmployee(2);
		System.out.println(empp.getId());
		System.out.println(empp.getName());
		System.out.println(empp.getSalary());
		System.out.println(empp.getEmail());
		System.out.println(empp);
		System.out.println("=========Connection CallBack================");

		Employee em1 = em.findbyId_CallBack(5);
		System.out.println(em1);
		System.out.println("=========prepare Statement CallBack================");

		Employee em2 = em.findbyId_prepareCallBack(5);
		System.out.println(em2);

		System.out.println("=========Stored Function================");
		// return only one name
		Employee em3 = em.getEmployee_Function(2);
		System.out.println(em3.getName());
		System.out.println(em.getEmployee_Function(5));
	}
}
