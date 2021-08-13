package com.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	
	// Autowire the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		// Get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// Create query
		Query<Customer> customerQuery = session.createQuery("from Customer order by lastName", Customer.class);
		
		// Execute query and get result list
		List<Customer> customers = customerQuery.getResultList();
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		
		// Get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// Save the customer
		session.saveOrUpdate(customer);		
	}

	@Override
	public Customer getCustomer(int customerID) {
		
		// Get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve from database using the primary key
		Customer customer = session.get(Customer.class, customerID);
		
		return customer;
	}

	@Override
	public void deleteCustomer(int customerID) {
		
		// Get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// Delete object with primary key
		Query query = session.createQuery("delete from Customer where id = :customerID");
		
		// Set customer ID
		query.setParameter("customerID", customerID);
		
		// Execute the query
		query.executeUpdate();
		
		
	}

}
