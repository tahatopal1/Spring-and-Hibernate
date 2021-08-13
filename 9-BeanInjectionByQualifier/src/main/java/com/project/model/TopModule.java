package com.project.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TopModule {
	
	@Autowired
	@Qualifier("motorcycle") // Inject the motorcycle bean
	private Vecihle vecihle;
	
	public void makeDesc() {
		vecihle.vecihleDesc();
	}
	
}
