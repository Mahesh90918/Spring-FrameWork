package com.aop.cross_cutting_functionalities;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class LoggingService implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
	
		System.out.println("LoggingService  :"+method.getName());
		
	}

}
