package com.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.project.model.BottomModel;
import com.project.model.BottomModelImpl;
import com.project.model.TopModel;
import com.project.model.TopModelImpl;

@Configuration
public class JavaConfig {
	
	@Bean
	public BottomModel bottomModelBean() {
		return new BottomModelImpl();
	}
	
	@Bean
	public TopModel topModelBean() {
		return new TopModelImpl(bottomModelBean());
	}
	
}
