package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.project.entity.Employee;

@RepositoryRestResource(path = "members") // default path was "employees"
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	// http://localhost:8080/power-api/members?page=1 to go page 1 (pages start with 0)
	// http://localhost:8080/power-api/members?sort=lastName >> sort by last name ascending
	// http://localhost:8080/power-api/members?sort=lastName,desc >> sort by last name descending
}
