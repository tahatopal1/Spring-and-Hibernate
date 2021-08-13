package com.project.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class SampleAspect1 {
	
	// Pointcut definition
	@Pointcut("execution(* com.project.dao.SampleDAO.sampleDAOMethod())")
	public void samplePointcut() {
		
	}
	
	@Before("samplePointcut()")
	public void advice1() {
		System.out.println("This is advice1");
	}
}
