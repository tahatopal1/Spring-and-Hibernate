package com.project.model;

import org.springframework.beans.factory.annotation.Value;

public class Member {
	
	@Value("${name}")
	private String name;
	
	@Value("${surname}")
	private String surname;
	
	@Value("${age}")
	private int    age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	

}
