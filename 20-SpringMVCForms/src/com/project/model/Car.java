package com.project.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Car {
	
	private String brand;
	private String subModel;
	private String type;
	private String assuranceType;
	private String color;
	private double motor;
	private String year;
	private String[] additions;
	
	// With Java Options - Combobox
	private List<String> assuranceTypes;
	
	// With Java Options - RadioButton
	private Map<String, String> years;
	
	public Car() {
		
		// Populate assurance options
		assuranceTypes = new ArrayList<String>();
		assuranceTypes.add("Assurance Free");
		assuranceTypes.add("6-Months assurance");
		assuranceTypes.add("12-Months assurance");
		
		// Populate year options
		years = new HashMap<String, String>();
		years.put("2018", "2018");
		years.put("2019", "2019");
		years.put("2020", "2020");
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSubModel() {
		return subModel;
	}

	public void setSubModel(String subModel) {
		this.subModel = subModel;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAssuranceType() {
		return assuranceType;
	}

	public void setAssuranceType(String assuranceType) {
		this.assuranceType = assuranceType;
	}

	public List<String> getAssuranceTypes() {
		return assuranceTypes;
	}

	public void setAssuranceTypes(List<String> assuranceTypes) {
		this.assuranceTypes = assuranceTypes;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getMotor() {
		return motor;
	}

	public void setMotor(double motor) {
		this.motor = motor;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Map<String, String> getYears() {
		return years;
	}

	public void setYears(Map<String, String> years) {
		this.years = years;
	}

	public String[] getAdditions() {
		return additions;
	}

	public void setAdditions(String[] additions) {
		this.additions = additions;
	}
	
	
}
