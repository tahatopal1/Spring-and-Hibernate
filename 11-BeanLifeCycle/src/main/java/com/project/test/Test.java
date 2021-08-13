package com.project.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.model.Member;

public class Test {
	public static void main(String[] args) {
		
		// Reading the XML config file
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
		
		// Catching the member bean
		Member member = applicationContext.getBean("memberBean", Member.class);
		
		// Closure of application context object
		applicationContext.close();
		
		
	}
}
