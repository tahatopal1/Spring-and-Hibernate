package com.project.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.config.JavaConfig;
import com.project.model.Member;

public class Test {

	public static void main(String[] args) {
		
		// Reading the Java config file
		ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
		
		// Getting Member bean
		Member member = applicationContext.getBean("memberBean", Member.class);
		
		// Print Member info
		System.out.println("Member name: "    +	member.getName());
		System.out.println("Member surname: " + member.getSurname());
		System.out.println("Member name: " 	  +	member.getAge());
		
		// Closure of application context
		applicationContext.close();
		
	}

}
