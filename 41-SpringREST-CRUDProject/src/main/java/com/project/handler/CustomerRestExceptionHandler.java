package com.project.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.project.exception.CustomerErrorResponse;
import com.project.exception.CustomerNotFoundException;

@ControllerAdvice
public class CustomerRestExceptionHandler {
	
	// Exception handler for CustomerNotFoundException
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exc){
		
		CustomerErrorResponse customerErrorResponse = 
											new CustomerErrorResponse(HttpStatus.NOT_FOUND.value(), 
																	 exc.getMessage(), 
																	 System.currentTimeMillis());
		
		return new ResponseEntity<>(customerErrorResponse, HttpStatus.NOT_FOUND);
	}
	
	// Exception handler to catch any exception
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleAnyException(Exception exc){
		
		CustomerErrorResponse customerErrorResponse = 
											new CustomerErrorResponse(HttpStatus.BAD_REQUEST.value(), 
																	 exc.getMessage(), 
																	 System.currentTimeMillis());
		
		return new ResponseEntity<>(customerErrorResponse, HttpStatus.BAD_REQUEST);
	}
	
}
