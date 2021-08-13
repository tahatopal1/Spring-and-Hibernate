package com.project.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.config.AppConfig;
import com.project.dao.ApplicationDAO;
import com.project.dao.MemberDAO;

public class Test {

	public static void main(String[] args) {
		
		// Initiate application context
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		// Get application dao object
		ApplicationDAO applicationDAO = context.getBean(ApplicationDAO.class);
		
		// Get member dao object
		MemberDAO memberDAO = context.getBean(MemberDAO.class);
		
		
		// Insert element method, will trigger an advice
		applicationDAO.insertElement();
		System.out.println("*********************");
		
		// Getter/setter calls, wont trigger any advice
		memberDAO.setName("Taha");
		memberDAO.setSurname("Topal");
		
		memberDAO.getName();
		memberDAO.getSurname();
		
		// Introduce method, will trigger an advice
		memberDAO.introduceMember();
		System.out.println("*********************");
		
		// Run JoinPoint example
		applicationDAO.methodWithParams(10, "String", false);
		System.out.println("*********************");
		
		// Run After Returning example
		applicationDAO.getNames();
		System.out.println("*********************");
		
		try {
			applicationDAO.methodForThrowAdvice(false);
		}catch (Exception e) {
			System.out.println("bla bla bla");
		}
		System.out.println("*********************");
		
		// Close the context
		context.close();
	}

}
