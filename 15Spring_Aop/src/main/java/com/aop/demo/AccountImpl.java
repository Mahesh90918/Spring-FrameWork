package com.aop.demo;

public class AccountImpl implements Account {

	@Override
	public void withdraw() {

		System.out.println("AccountImpl Withdraw method");

	}

	@Override
	public void deposit() {
		System.out.println("AccountImpl deposit method");
	}

}
