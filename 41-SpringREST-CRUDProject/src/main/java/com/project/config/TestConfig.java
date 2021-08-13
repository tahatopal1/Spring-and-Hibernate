package com.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.project.entity.Sample;

//@Configuration
//@PropertySource("classpath:persistence-mysql.properties")
public class TestConfig {
	
	/*@Autowired
	private Environment environment;
	
	@Bean
	public Sample getSample() {
		Sample sample = new Sample();
		sample.setTest(environment.getProperty("hibernate.packagesToScan"));
		return sample;
	}*/
}
