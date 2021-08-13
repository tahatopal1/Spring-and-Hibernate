package com.project.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.config.JavaConfig;
import com.project.model.TopModel;

public class Test {

	public static void main(String[] args) {
		
		// Reading Java config class
		ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
		
		// Catching bean
		TopModel topModel = applicationContext.getBean("topModelBean", TopModel.class);
		
		// Running model method
		topModel.topModelMethod();
		
		// closure of application context
		applicationContext.close();
	}

}
