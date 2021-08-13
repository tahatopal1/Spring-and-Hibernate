package com.project.service;

import java.util.List;

import com.project.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee employee);
	
	public void delete(int id);
	
	public List<Employee> searchBy(String employee);
	
}
