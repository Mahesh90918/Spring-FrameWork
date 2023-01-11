package com.aop.cross_cutting_functionalities;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class TransactionService implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
	System.out.println("TransanctionService :"+method.getName());
		
	}

}
