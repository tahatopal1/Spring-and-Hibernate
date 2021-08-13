package com.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.project.model.Member;

@Configuration
@PropertySource("classpath:member.properties")
public class JavaConfig {
	
	@Bean
	public Member memberBean() {
		return new Member();
	}

}
