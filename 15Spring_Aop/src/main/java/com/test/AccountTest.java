package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aop.demo.Account;

public class AccountTest {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("Spring_Aop.xml");
		Account ai = (Account) ac.getBean("id4");
		ai.withdraw();
		ai.deposit();
	}
}
