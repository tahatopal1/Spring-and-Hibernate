package com.project.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.model.Vecihle;

public class Test {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext applicationContext 
											= new ClassPathXmlApplicationContext("application-context.xml");
		
		Vecihle car = applicationContext.getBean("carBean", Vecihle.class);
		System.out.println("Vecihle desc: ".concat(car.vecihleDesc()));
		System.out.println("Vecihle wheel desc: ".concat(car.vecihleWheelDesc()));
		
		applicationContext.close();

	}

}
