package com.project.model;

public class Member{
	
	private String name;
	private String surname;
	private int	   age;
	
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
	
	public void memberInitialization() {
		System.out.println("Member initalization: " + this);
	}
	
	public void memberDestruction() {
		System.out.println("Member destruction: " + this);
	}
	
	@Override
	public String toString() {
		return "Member [name=" + name + ", surname=" + surname + ", age=" + age + "]";
	}

}
