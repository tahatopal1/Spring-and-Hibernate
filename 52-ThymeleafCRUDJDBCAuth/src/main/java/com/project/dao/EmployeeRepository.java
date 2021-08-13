package com.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	// Method to sort by last name
	public List<Employee> findAllByOrderByLastNameAsc();
	
	// Search by name
	public List<Employee> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name, String lname);
}
