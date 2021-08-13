package com.project.model;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tahat
 *
 */
public class Test {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Sport sport = applicationContext.getBean("soccerBean", Sport.class);
		sport.training();
		
		sport = applicationContext.getBean("basketballBean", Sport.class);
		sport.training();
		
		applicationContext.close();
	}

}
