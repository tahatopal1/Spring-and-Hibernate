package com.project.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.model.Vecihle;

public class Test {

	public static void main(String[] args) {
		
		// Read the configuration file
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
		
		// Catch the bean with explicit bean id
		Vecihle car = applicationContext.getBean("explicitCar", Vecihle.class);
		
		// Run the bean method
		car.printVecihleDesc();
		
		// Catch the bean with default bean id
		car = applicationContext.getBean("jeep", Vecihle.class);
		
		// Run the bean method
		car.printVecihleDesc();
		
		// Close the IoC container
		applicationContext.close();
		
		
	}

}
