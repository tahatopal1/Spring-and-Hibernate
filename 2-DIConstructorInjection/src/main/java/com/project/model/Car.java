package com.project.model;

public class Car implements Vecihle {
	
	private VecihleWheel vecihleWheel;
	
	public Car(VecihleWheel vecihleWheel) {
		super();
		this.vecihleWheel = vecihleWheel;
	}

	public String vecihleDesc() {
		return "Sport Car";
	}

	public String vecihleWheelDesc() {
		return vecihleWheel.vecihleWheelDesc();
	}

}
