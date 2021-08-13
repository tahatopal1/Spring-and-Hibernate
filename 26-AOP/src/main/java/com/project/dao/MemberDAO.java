package com.project.dao;

import org.springframework.stereotype.Component;

@Component
public class MemberDAO {
	
	// Attributes
	private String name;
	private String surname;
	
	// Getter / Setters
	public String getName() {
		System.out.println("In method: getName");
		return name;
	}
	public void setName(String name) {
		System.out.println("In method: setName");
		this.name = name;
	}
	public String getSurname() {
		System.out.println("In method: getSurname");
		return surname;
	}
	public void setSurname(String surname) {
		System.out.println("In method: setSurname");
		this.surname = surname;
	}
	
	// Exclusive method
	public void introduceMember() {
		System.out.println("Here's the member: ".concat(this.name).concat(" ").concat(this.surname));
	}
	
}
