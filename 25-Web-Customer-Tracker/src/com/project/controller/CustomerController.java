package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.entity.Customer;
import com.project.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// Injection of CustomerService
	
	@Autowired 
	private CustomerService customerService;
	
	@RequestMapping("/list")
	public String listCustomers(Model model) {
		
		// Get customers via dao
		List<Customer> customers = customerService.getCustomers();
		
		// Add the customers to the model
		model.addAttribute("customers", customers);
		
		// Navigate to list-customers page
		return "list-customers";
	}
	
	@RequestMapping("/customer-form")
	public String customerForm(Model model) {
		// Navigates to customer form page
		
		// Create model attribute to bind form data
		Customer customer = new Customer();
		
		// Bind the model
		model.addAttribute("customer", customer);
		
		return "customer-form";
		
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		
		// Saves the customer and redirects list page
		customerService.saveCustomer(customer);
		
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/customer-form-update")
	public String customerFormUpdate(@RequestParam("customerID") int customerID, Model model) {
		
		// Get the customer from the database
		Customer customer = customerService.getCustomer(customerID);
		
		// Set customer as a model attribute to pre-populate the form
		model.addAttribute("customer", customer);
		
		// Send over to form
		return "customer-form";
	}
	
	@GetMapping("/customer-delete")
	public String customerDelete(@RequestParam("customerID") int id) {
		
		// Delete the customer
		customerService.deleteCustomer(id);
		
		// Redirect to list page
		return "redirect:/customer/list";
		
		}
}
