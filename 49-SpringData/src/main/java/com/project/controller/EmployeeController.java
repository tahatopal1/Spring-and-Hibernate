package com.project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Employee;
import com.project.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	private EmployeeService employeeService;

	// Quick and dirty: Inject employee dao
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	// Expose "/employees" and return list of employees
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	// Mapping for GET /employees/{id}
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable int id) {
		Employee employee = employeeService.findById(id);
		if (employee == null) {
			throw new RuntimeException("Employee id not found - " + id);
		}
		return employee;
	}
	
	// Mapping for POST /employees - add new employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		employee.setId(0); // In case they pass id in JSON, we set id to 0 to force saving a new item
		employeeService.save(employee);
		return employee;
	}
	
	// Mapping for PUT /employees - update an employee
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
		return employee;
	}
	
	// Mapping for DELETE /employees - remove an employee
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable int id) {
		Employee employee = employeeService.findById(id);
		if (employee == null) {
			throw new RuntimeException("Employee id not found - " + id);
		}
		employeeService.delete(id);
		return "Deleted employee id - " + id;
	}
	
}
