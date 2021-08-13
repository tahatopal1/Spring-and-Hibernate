package com.project.dao;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ApplicationDAO {
	
	public void insertElement() {
		System.out.println("Insert element by DAO");
	}
	
	public void methodWithParams(int number, String str, boolean condition) {
		
	}
	
	public List<String> getNames(){
		return List.of("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptun", "Pluto");
	}
	
	public void methodForThrowAdvice(boolean bool) throws Exception {
		if(!bool)
			throw new Exception("Throwing exception for after returning advice");
		System.out.println("Throws exception");
	}

	public void methodForAfterAdvice() {
		System.out.println("After advice!!!");
	}
	
}
