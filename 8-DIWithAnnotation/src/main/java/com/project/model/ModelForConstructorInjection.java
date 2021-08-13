package com.project.model;

import org.springframework.stereotype.Component;

@Component
public class ModelForConstructorInjection {
	public void desc() {
		System.out.println("Desc: ModelForConstructorInjection");
	}
}
