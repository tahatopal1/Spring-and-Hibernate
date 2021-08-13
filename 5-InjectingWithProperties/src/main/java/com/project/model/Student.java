package com.project.model;

public class Student {
	
	private String name;
	private String surname;
	private int	   course;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("Setter method for name property: ".concat(name));
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		System.out.println("Setter method for name property: ".concat(surname));
		this.surname = surname;
	}
	public int getCourse() {
		return course;
	}
	public void setCourse(int course) {
		System.out.println("Setter method for name property: ".concat(String.valueOf(course)));
		this.course = course;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", surname=" + surname + ", course=" + course + "]";
	}
	
	
	
}
