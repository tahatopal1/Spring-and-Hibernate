package com.project.model;

import org.springframework.stereotype.Component;

@Component("explicitCar")
public class Car implements Vecihle {

	public void printVecihleDesc() {
		System.out.println("Vecihle is a Car");
	}

}
