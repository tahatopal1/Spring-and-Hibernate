package com.project.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.config.JavaConfig;
import com.project.model.SampleModel;

public class Test {

	public static void main(String[] args) {
		
		// Reading the Java configuration file
		ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
		
		// Catching the bean
		SampleModel sampleModel = applicationContext.getBean(SampleModel.class);
		
		// Using the method
		sampleModel.sampleMethod();
		
		// Closure of application context
		applicationContext.close();
	}

}
