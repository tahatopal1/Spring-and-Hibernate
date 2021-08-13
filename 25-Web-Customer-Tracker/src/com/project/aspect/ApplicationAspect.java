package com.project.aspect;

import java.util.Arrays;
import java.util.Iterator;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ApplicationAspect {
	
	// Initiate Logger
	private Logger logger = Logger.getLogger(getClass().getName());
	
	// Pointcut for controller package
	@Pointcut("execution (* com.project.controller.*.*(..))")
	private void pointcutControllerPackage() {
		
	}
	
	// Pointcut for service package
	@Pointcut("execution (* com.project.service.*.*(..))")
	private void pointcutServicePackage() {
		
	}
	
	// Pointcut for dao package
	@Pointcut("execution (* com.project.dao.*.*(..))")
	private void pointcutDaoPackage() {
		
	}
	
	// Pointcut for main flow
	@Pointcut("pointcutControllerPackage() || pointcutServicePackage() || pointcutDaoPackage()")
	private void mainFlow() {
		
	}
	
	@Before("mainFlow()")
	private void beforeMainFlow(JoinPoint joinPoint) {
		
		// Display the method signature
		logger.info("Calling method: " + joinPoint.getSignature().toShortString());
		
		// Display the arguments
		logger.info("Arguments: ");
		for(Object o: joinPoint.getArgs()) {
			logger.info(o.toString());
		}
		
	}
	
	@AfterReturning(pointcut = "mainFlow()", returning = "result")
	public void afterReturningMainFlow(JoinPoint joinPoint, Object result) {
		
		// Display the method signature
		logger.info("Calling method: " + joinPoint.getSignature().toShortString());
		
		// Display the data returned
		logger.info("result: " + result);
		
	}
	
}
