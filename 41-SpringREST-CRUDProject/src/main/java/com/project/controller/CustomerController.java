package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Customer;
import com.project.exception.CustomerNotFoundException;
import com.project.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	// Autowire the customer service
	@Autowired
	private CustomerService customerService;
	
	// Mapping for GET /customers
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		return customerService.getCustomers();
	}
	
	// Mapping for GET /customers/{customerId}
	@GetMapping("/customers/{id}")
	public Customer getCustomer(@PathVariable int id) {
		Customer customer = customerService.getCustomer(id);
		
		if (customer == null) {
			throw new CustomerNotFoundException("Customer id is not found - " + id);
		}
		
		return customer;
	}
	
	// Mapping for POST /customers - add a customer
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		
		customer.setId(0); // force to save a new item instead of update
		customerService.saveCustomer(customer);
		
		return customer;
	}
	
	// Mapping for PUT /customers - update existing customer
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {
		
		if (customer.getId() == 0) {
			throw new CustomerNotFoundException("Missing attribute: id");
		}
		
		customerService.saveCustomer(customer);
		return customer;
	}
	
	@DeleteMapping("/customers/{id}")
	public String deleteCustomer(@PathVariable int id) {
		
		Customer customer = customerService.getCustomer(id);
		
		if (customer == null) {
			throw new CustomerNotFoundException("Customer id not found - " + id);
		}
		
		customerService.deleteCustomer(id);
		return "Deleted customer id - " + id;
	}
	
}
