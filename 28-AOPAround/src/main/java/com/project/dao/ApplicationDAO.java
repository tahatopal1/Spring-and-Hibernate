package com.project.dao;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class ApplicationDAO {
	
	public String sendInfo(boolean throwControl, boolean reverseThrowControl) {
		
		try {
			
			// Sleep the method for 5 seconds
			TimeUnit.SECONDS.sleep(5);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return "Information message";
		
	}
}
