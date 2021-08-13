package com.project.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.config.ApplicationConfig;
import com.project.dao.ApplicationDAO;

public class Test {
	public static void main(String[] args) {
		
		// Initialize IoC container
		ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		// Fetch DAO bean
		ApplicationDAO applicationDAO = applicationContext.getBean(ApplicationDAO.class);
		
		// Run the method
		applicationDAO.sendInfo(false, false);
		
		// Close the IoC container
		applicationContext.close();
		
	}
}
