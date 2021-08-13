package com.project.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.project.entity.StudentErrorResponse;
import com.project.exception.StudentNotFoundException;

// Exception handler method can only be used in one controller
// To globalise handler services, we moved them to the handler class
// Any handler service inside the handler can be reached from any controller

@ControllerAdvice
public class StudentRestExceptionHandler {
	// Exception handler using @ExceptionHandler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
		
		// Create a StudentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		// Return entity
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	// Generic exception handler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
		
		// Create a StudentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		// Return entity
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
