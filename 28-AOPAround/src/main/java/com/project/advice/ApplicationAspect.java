package com.project.advice;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ApplicationAspect {
	
	private boolean throwControl;
	private boolean reverseThrowControl;
	
	// Log the info in order 
	private static Logger logger = Logger.getLogger(ApplicationAspect.class.getName());
	
	@Pointcut("execution (* com.project.dao.ApplicationDAO.sendInfo(..))")
	public void sendInfoPointcut() {
		
	}
	
	@Around("sendInfoPointcut()")
	public void sendInfoAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		
		// Display method signature
		logger.info("Method signature: " + joinPoint.getSignature().toShortString());
		
		// Fetch the beginning time
		long begin = System.currentTimeMillis();
		
		try {
			
			// Initiate the method processing
			joinPoint.proceed();
			
			// Fetch the arguments
			Object[] objs = joinPoint.getArgs();
			
			// Fetch the controls from arguments
			throwControl = (boolean) objs[0];
			reverseThrowControl = (boolean) objs[1];
			
			if (throwControl) {
				throw new Exception("Mock error");
			}
			
		} catch (Throwable e) {
			
			if (!reverseThrowControl) {
				logger.info(e.getMessage().concat(": ").concat("not a big deal"));
			}else {
				throw e;
			}
		}
		
		// Fetch the finishing time
		long end = System.currentTimeMillis();
		
		// Print the lasted time
		logger.info("Time lasted: " + ((end - begin) / 1000) + " seconds");
	}
	
}
