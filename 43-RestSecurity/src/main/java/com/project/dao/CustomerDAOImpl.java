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

	// Injection of session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		// Getting the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// Listing query (sorted by last name)
		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);
		
		// Query execution
		List<Customer> customers = query.getResultList();
		
		return customers;
		
	}

	@Override
	public void saveCustomer(Customer customer) {
		
		// Getting the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		
		// Getting the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve the customer by using the primary key
		Customer customer = session.get(Customer.class, id);
		
		return customer;
		
	}

	@Override
	public void deleteCustomer(int id) {
		
		// Getting the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// Delete object with primary key
		Query query = session.createQuery("delete from Customer where id = :id");
		query.setParameter("id", id);
		
		query.executeUpdate();
		
	}

}
