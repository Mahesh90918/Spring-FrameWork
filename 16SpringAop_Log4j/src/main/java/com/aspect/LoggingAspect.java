package com.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.controller.EmployeeController;

@Aspect
public class LoggingAspect {
	private static final Logger log = Logger.getLogger(EmployeeController.class);

	@Before("execution(* com.controller.EmployeeController.*(..))")
	public void logMethodStart(JoinPoint point) {
		log.info("###" + point.getSignature().getName() + "### STARTING......");
	}

	@After("execution(* com.controller.EmployeeController.*(..))")
	public void logMethodEnd(JoinPoint point) {
		log.info("###" + point.getSignature().getName() + "### ENDED......");
	}

	@AfterReturning(pointcut = "execution(* com.controller.EmployeeController.*(..))", returning = "result")
	public void logReturningValue(JoinPoint point, Object result) {
		log.info("###" + point.getSignature().getName() + ":" + result + "###");
	}
}
