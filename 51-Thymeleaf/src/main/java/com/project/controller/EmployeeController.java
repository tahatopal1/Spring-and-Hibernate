package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	// Load employee data
	private List<Employee> employees;
	
	@PostConstruct
	private void loadData() {
		
		// Create employees
		Employee emp1 = new Employee(1, "Leslie", "Andrews", "leslie@mail.com");
		Employee emp2 = new Employee(2, "Emma", "Baumgarten", "emma@mail.com");
		Employee emp3 = new Employee(3, "Avani", "Gupta", "avani@mail.com");
		
		// Create the list
		employees = new ArrayList<>();
		
		// Add to the list
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
	}
	
	// Mapping for /list
	@GetMapping("/list")
	public String listEmployees(Model model) {
		
		// Add to the spring model
		model.addAttribute("employees", employees);
		
		return "list-employees";
	}
	
}
