package com.project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Student;
import com.project.entity.StudentErrorResponse;
import com.project.exception.StudentNotFoundException;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	private List<Student> students;
	
	@PostConstruct
	public void initializeStudentsList() {
		students = new ArrayList<Student>();
		students.add(new Student("Name1", "Surname1"));
		students.add(new Student("Name2", "Surname2"));
		students.add(new Student("Name3", "Surname3"));
	}
	
	
	@GetMapping("/hello")
	public String helloMessage() {
		return "Hello test";
	}
	
	@GetMapping("/allStudents")
	public List<Student> getAllStudents(){
		return this.students;
	}
	
	@GetMapping("/allStudents/{studentId}")
	public Student getOneStudent(@PathVariable int studentId){
		
		
		if ((studentId >= this.students.size()) || studentId < 0) {
			throw new StudentNotFoundException("Student id not found - " + studentId);
		}
		
		return this.students.get(studentId);
		
	}
	
	/* This section was moved to com.project.handler.StudentRestExceptionHandler
	
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
	
	*/
}
