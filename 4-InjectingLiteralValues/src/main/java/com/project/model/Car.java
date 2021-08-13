package com.project.model;

public class Car {
	
	private String name;
	private String model;
	private int    year;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("Setter method for name property: ".concat(name));
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		System.out.println("Setter method for model property: ".concat(model));
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		System.out.println("Setter method for year property: ".concat(String.valueOf(year)));
		this.year = year;
	}
	
	
	
}
