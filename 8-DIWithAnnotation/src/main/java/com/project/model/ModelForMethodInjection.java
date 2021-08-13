package com.project.model;

import org.springframework.stereotype.Component;

@Component
public class ModelForMethodInjection {
	public void desc() {
		System.out.println("Desc: ModelForMethodInjection");
	}
}
