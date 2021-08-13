package com.project.advice;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ApplicationAdvice {
	
	// Will be triggered after insertElement method on the project
	@Before("execution (public void insertElement())")
	public void beforeInsertElementAdvice() {
		System.out.println("Before advice for 'insertElement'");
	}
	
	// Pointcut definition for every method in MemberDAO
	@Pointcut("execution (* com.project.dao.MemberDAO.*(..))")
	public void memberDAOMethods() {
		
	}
	
	// Pointcut definition for getter methods on MemberDAO
	@Pointcut("execution (* com.project.dao.MemberDAO.get*(..))")
	public void memberDAOGetters() {
		
	}
	
	// Pointcut definition for setter methods on MemberDAO
	@Pointcut("execution (* com.project.dao.MemberDAO.set*(..))")
	public void memberDAOSetters() {
		
	}
	
	// Pointcut definiton for every method in MemberDAO except getter and setters
	@Pointcut("memberDAOMethods() && !(memberDAOGetters() || memberDAOSetters())")
	public void memberDAOMethodsExclusive() {
		
	}
	
	// Before advice for methods on MemberDAO except getter/setters
	@Before("memberDAOMethodsExclusive()")
	public void memberDAOMethodsExclusiveBeforeAdvice() {
		System.out.println("memberDAOMethodsExclusiveBeforeAdvice");
	}
	
	// Advice for JoinPoint example
	@Before("execution (* com.project.dao.ApplicationDAO.methodWithParams(int, String, boolean))")
	public void adviceForMethodWithParams(JoinPoint joinPoint) {
		
		// Fetch method signature
		Signature signature = joinPoint.getSignature();
		
		// Display method signature
		System.out.println("Method signature ".concat(signature.toString()));
		
		// Fetch method arguments
		Object[] args = joinPoint.getArgs();
		
		// Display arguments
		for(Object obj: args) {
			System.out.println("Type: " + obj.getClass());
			System.out.println("Value: " + obj);
		}
			
	}
	
	// Advice for ApplicationDAO.getNames() with 'After Returning'
	@AfterReturning(pointcut = "execution (* com.project.dao.ApplicationDAO.getNames())", returning = "planets")
	public void adviceForGetNames(JoinPoint joinPoint, List<String> planets) {
		
		// Get method signature
		Signature signature = joinPoint.getSignature();
		
		// Display method signature
		System.out.println(signature);
		
		// Display returning stuff
		System.out.println(planets);
		
	}
	
	// Advice for ApplicationDAO.methodForThrowAdvice(boolean) with 'After Throwing'
	@AfterThrowing(pointcut = "execution (* com.project.dao.ApplicationDAO.methodForThrowAdvice(..))", throwing = "exception")
	public void adviceForThrowMethod(JoinPoint joinPoint, Throwable exception) {
		
		// Display message
		System.out.println("This is after returning advice");
		
		// Get method signature
		Signature signature = joinPoint.getSignature();
		
		// Display method signature
		System.out.println(signature);
		
		// Display throwing stuff
		System.out.println(exception.getMessage());
		
	}
	
	// Advice for ApplicationDAO.methodForThrowAdvice(boolean) with 'After'. This advice will run after 'AfterThrowing' before (adviceForThrowMethod) above.
	@After("execution (* com.project.dao.ApplicationDAO.methodForThrowAdvice(..))")
	public void adviceForMethodAfter(JoinPoint joinpoint) {
		
		// Display message
		System.out.println("This is after advice");
		
		// Get method signature
		Signature signature = joinpoint.getSignature();
		
		// Display method signature
		System.out.println(signature);
	}
	
}
