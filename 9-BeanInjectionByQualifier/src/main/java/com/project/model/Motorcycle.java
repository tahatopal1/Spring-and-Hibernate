package com.project.model;

import org.springframework.stereotype.Component;

@Component
public class Motorcycle implements Vecihle {

	@Override
	public void vecihleDesc() {
		System.out.println("Vecihle desc: Motorcycle");
	}

}
