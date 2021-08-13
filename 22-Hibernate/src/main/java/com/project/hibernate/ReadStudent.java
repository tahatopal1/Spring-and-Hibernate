package com.project.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.entity.Student;

public class ReadStudent {
	public static void main(String[] args) {
		 
		// Create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure()
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// Create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			// Create student object
			System.out.println("Creating a new student object...");
			Student student = new Student("Marc", "Anthony", "marc@mail.com");
			
			// Start a transaction
			session.beginTransaction();
			
			// Save the student object
			System.out.println("Saving the student object...");
			session.save(student);
			
			// Commit transaction
			session.getTransaction().commit();
			
			// Get a new session and start transaction
			session = sessionFactory.getCurrentSession();
			
			// Start new transaction
			session.beginTransaction();
			
			// Retrieve the student based on the id (primary key)
			System.out.println("Getting student with id: " + student.getId());
			Student myStudent = session.get(Student.class, student.getId());
			
			// Commit the transaction
			//session.getTransaction().commit();
			
			// Print the student
			System.out.println(myStudent);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close(); // Close the session
			sessionFactory.close(); // Close the sessionFactory
		}
		
	}
}
