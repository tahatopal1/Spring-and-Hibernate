package com.project.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class SampleAspect2 {
	
	@Before("com.project.aspect.SampleAspect1.samplePointcut()")
	public void advice1() {
		System.out.println("This is advice2");
	}
	
}
