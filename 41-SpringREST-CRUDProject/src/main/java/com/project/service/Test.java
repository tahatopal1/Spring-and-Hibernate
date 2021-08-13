package com.project.service;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.config.TestConfig;
import com.project.entity.Sample;

public class Test {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConfig.class);
		Sample sample = applicationContext.getBean(Sample.class);
		System.out.println(sample.getTest());
	}

}
