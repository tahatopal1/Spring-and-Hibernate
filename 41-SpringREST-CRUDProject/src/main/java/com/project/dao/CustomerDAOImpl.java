package com.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// Injection of the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		// Get the current hibernate section
		Session session = sessionFactory.getCurrentSession();
		
		// Query creation (sort by lastName)
		Query<Customer> query = session.createQuery("from Customer order by lastName");
		
		// Execute query and get result list
		List<Customer> customers = query.getResultList();
		
		return customers;
		
	}

	@Override
	public void saveCustomer(Customer customer) {

		// Get the current hibernate section
		Session session = sessionFactory.getCurrentSession();
		
		// Save/update the customer
		session.saveOrUpdate(customer);
		
	}

	@Override
	public Customer getCustomer(int id) {
		
		// Get the current hibernate section
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve/read from database using primary key
		Customer customer = session.get(Customer.class, id);
		
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		
		// Get the current hibernate section
		Session session = sessionFactory.getCurrentSession();
		
		// Deleting with primary key
		Query query = session.createQuery("delete from Customer where id = :id");
		query.setParameter("id", id);
		
		query.executeUpdate();
		
	}

}
