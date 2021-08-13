package com.project.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.model.TopModule;


public class Test {

	public static void main(String[] args) {
		
		// Reading the XML configuration file
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
		
		// Catching the topModule bean
		TopModule topModule = applicationContext.getBean("topModule", TopModule.class);
		
		// Using topModule description method
		topModule.makeDesc();
		
		// Closure of application context
		applicationContext.close();

	}

}
