package com.project.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.model.Car;

public class Test {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
		Car car = applicationContext.getBean("carBean", Car.class);
		
		System.out.println("Features:");
		System.out.println("Model: ".concat(car.getName()).concat(" ").concat(car.getModel()));
		System.out.println("Year: ".concat(String.valueOf(car.getYear())));
		
		applicationContext.close();
	}

}
