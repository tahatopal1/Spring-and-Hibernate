package com.project.model;

public class Car implements Vecihle {
	
	private VecihleWheel vecihleWheel;
	
	public Car() {
		System.out.println("No args constructor of Car");
	}

	public VecihleWheel getVecihleWheel() {
		return vecihleWheel;
	}

	public void setVecihleWheel(VecihleWheel vecihleWheel) {
		System.out.println("Setter method for VecihleWheel on Car");
		this.vecihleWheel = vecihleWheel;
	}

	public String vecihleDesc() {
		return "Sport Car";
	}

	public String vecihleWheelDesc() {
		return vecihleWheel.vecihleWheelDesc();
	}

}
