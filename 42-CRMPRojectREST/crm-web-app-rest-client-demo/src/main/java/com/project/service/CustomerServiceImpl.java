package com.project.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private RestTemplate restTemplate;
	
	//@Autowired
	//private Environment environment;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Value("${crm.rest.url}")
	private String restUrl;
	
	public CustomerServiceImpl() {
		//restUrl = environment.getProperty("${crm.rest.url}");
		//logger.info("Loaded property: crm.rest.url = " + restUrl);
	}

	@Override
	public List<Customer> getCustomers() {
		logger.info("in getCustomers(): Calling REST API " + restUrl);
		
		// REST call
		ResponseEntity<List<Customer>> responseEntity = 
				restTemplate.exchange(restUrl, HttpMethod.GET, null, 
									  new ParameterizedTypeReference<List<Customer>>() {});		
		
		// Getting the list of customers from response
		List<Customer> customers = responseEntity.getBody();
		
		logger.info("in getCustomers(): customers" + customers);
		
		return customers;
		
	}

	@Override
	public void saveCustomer(Customer customer) {
		
		logger.info("in saveCustomer(): Calling REST API " + restUrl);
		
		int employeeId = customer.getId();
		
		// REST call
		if (employeeId == 0) {
			// Add employee
			restTemplate.postForEntity(restUrl, customer, String.class);
		}else {
			// Update employee
			restTemplate.put(restUrl, customer);
		}
		
	}

	@Override
	public Customer getCustomer(int id) {
		
		logger.info("in getCustomer(): Calling REST API " + restUrl);
		
		// REST call
		Customer customer = restTemplate.getForObject(restUrl + "/" + id, Customer.class);
		
		return customer;
		
	}

	@Override
	public void deleteCustomer(int id) {
		
		logger.info("in deleteCustomer(): Calling REST API " + restUrl);
		
		// REST call
		restTemplate.delete(restUrl + "/" + id);
		
	}
	


}
