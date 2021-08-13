package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.entity.Employee;
import com.project.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// Mapping for /list
	@GetMapping("/list")
	public String listEmployees(Model model) {
		
		List<Employee> employees = employeeService.findAll();
		
		// Add to the spring model
		model.addAttribute("employees", employees);
		
		return "employees/list-employees";
	}
	
	@GetMapping("/addForm")
	public String showFormForAdd(Model model) {
		// Create model attribute to bind form data
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		
		// Save the employee
		employeeService.save(employee);
		
		// Use a redirection to prevent duplicate submissions
		return "redirect:/employees/list";
		
	}
	
	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("id") int id, Model model) {
		
		// Get the employee from the service
		Employee employee = employeeService.findById(id);
		
		// Set employee as a model attribute to pre-populate the form
		model.addAttribute("employee", employee);
		
		// Send over to form
		return "employees/employee-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		
		// Delete the employee
		employeeService.delete(id);
		
		// Redirect to /employees/list
		return "redirect:/employees/list";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam("employee") String employee, Model model) {
		
		// Search the employee
		List<Employee> employees = employeeService.searchBy(employee);
		
		model.addAttribute("employees", employees);
		return "/employees/list-employees";
	}
	
}
