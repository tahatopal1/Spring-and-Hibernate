package com.project.dao;

import java.util.List;

import com.project.entity.Customer;

public interface CustomerDAO {
	
	// Method for getting all customers
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int customerID);

	public void deleteCustomer(int customerID); 
}
