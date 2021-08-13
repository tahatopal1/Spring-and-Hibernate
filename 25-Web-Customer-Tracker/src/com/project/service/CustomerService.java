package com.project.service;

import java.util.List;

import com.project.entity.Customer;

public interface CustomerService {
	
	// Service for getting all customers
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int customerID);

	public void deleteCustomer(int id); 
}
