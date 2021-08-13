package com.project.model;

import org.springframework.stereotype.Component;

@Component
public class Jeep implements Vecihle {

	public void printVecihleDesc() {
		System.out.println("Vecihle is a Jeep");
	}

}
