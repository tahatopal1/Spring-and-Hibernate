package com.project.driver;

import java.io.File;
import java.util.Iterator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.model.Address;
import com.project.model.Student;

public class Driver {

	public static void main(String[] args) {
		try {
			
			// Create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			// Read JSON file and map/conver to Java POJO: data/sample-lite.json
			//Student student = mapper.readValue(new File("data/sample-lite.json"), Student.class);
			Student student = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			// Print first and last names
			System.out.println("First name: " + student.getFirstName());
			System.out.println("Last name: " + student.getLastName());
			
			// Print out address: street and city
			Address address = student.getAddress();
			
			System.out.println("Street: " + address.getStreet());
			System.out.println("City: " + address.getCity());
			
			// Print out the languages
			for (String language : student.getLanguages()) {
				System.out.println(language);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
