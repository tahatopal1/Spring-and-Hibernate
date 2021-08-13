package com.project.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.dao.SampleDAO;

public class Test {

	public static void main(String[] args) {
		
		// Initiate application context
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
		
		// Get DAO object
		SampleDAO sampleDAO = applicationContext.getBean(SampleDAO.class);
		
		// Run the method, advices will be triggered according to their orders
		sampleDAO.sampleDAOMethod();
		
		// Close the IoC container
		applicationContext.close();
		
	}

}
