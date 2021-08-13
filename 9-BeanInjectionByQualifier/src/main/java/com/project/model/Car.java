package com.project.model;

import org.springframework.stereotype.Component;

@Component
public class Car implements Vecihle {

	@Override
	public void vecihleDesc() {
		System.out.println("Vecihle desc: Car");
	}

}
