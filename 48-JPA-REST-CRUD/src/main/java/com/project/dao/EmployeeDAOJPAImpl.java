package com.project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.entity.Employee;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {

	// Define field for entitymanager
	private EntityManager entityManager;
	
	// Set up constructor injection
	@Autowired // No need to use autowired actually
	public EmployeeDAOJPAImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		
		// Create a query
		Query query = entityManager.createQuery("from Employee", Employee.class);
		
		// Execute query and get result list
		List<Employee> employees = query.getResultList();
		
		// Return the results
		return employees;
	}

	@Override
	public Employee findById(int id) {
		
		// Get the employee
		Employee employee = entityManager.find(Employee.class, id);
		
		// Return the employee
		return employee;
	}

	@Override
	public void save(Employee employee) {
		// Save the employee
		Employee dbEmployee = entityManager.merge(employee);
		employee.setId(dbEmployee.getId());
	}

	@Override
	public void delete(int id) {
		
		// Delete object with primary key
		Query query = entityManager.createQuery("delete from Employee where id = :id");
		query.setParameter("id", id);
		
		query.executeUpdate();
	}

}
