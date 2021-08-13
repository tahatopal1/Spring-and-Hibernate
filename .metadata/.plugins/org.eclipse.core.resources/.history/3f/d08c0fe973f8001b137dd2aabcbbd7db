package com.project.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// Define field for entitymanager
	private EntityManager entityManager;
	
	// Set up constructor injection
	@Autowired // No need to use autowired actually
	public EmployeeDAOHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		
		// Get the current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		// Create a query
		Query<Employee> query = session.createQuery("from Employee", Employee.class);
		
		// Execute query and get result list
		List<Employee> employees = query.getResultList();
		
		// Return the results
		return employees;
	}

	@Override
	public Employee findById(int id) {
		
		// Get the current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		// Get the employee
		Employee employee = session.get(Employee.class, id);
		
		// Return the employee
		return employee;
	}

	@Override
	public void save(Employee employee) {
		
		// Get the current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		// Save the employee
		session.saveOrUpdate(employee);
		
	}

	@Override
	public void delete(int id) {
		
		// Get the current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		// Delete object with primary key
		Query query = session.createQuery("delete from Employee where id = :id");
		query.setParameter("id", id);
		
		query.executeUpdate();
	}

}
