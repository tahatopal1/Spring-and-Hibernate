package com.project.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.model.TopModule;

public class Test {

	public static void main(String[] args) {
		
		// Reading XML configuration file
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
		
		// Catching topModule bean
		TopModule topModule = applicationContext.getBean("topModule", TopModule.class);
		
		// Running methods
		topModule.modelForConstructorInjection.desc();
		topModule.modelForSetterInjection.desc();
		topModule.modelForMethodInjection.desc();
		topModule.modelForFieldInjection.desc();
		
		// Closing the application context
		applicationContext.close();
		
		
	}

}
