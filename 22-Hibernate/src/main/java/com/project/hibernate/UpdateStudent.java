package com.project.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.entity.Student;

public class UpdateStudent {

	public static void main(String[] args) {
		
		// Create a session factory
		SessionFactory sessionFactory = new Configuration()
				.configure()
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// Create a session
		Session session = sessionFactory.getCurrentSession();
		
		// Define a student id
		int studentId = 4;
		
		try {

			// Begin transaction
			session.beginTransaction();
			
			// Getting student with id
			System.out.println("Getting student with id: " + studentId);
			Student student = session.get(Student.class, studentId);
			
			// Update student
			System.out.println("Updating the student with id: " + studentId);
			student.setEmail("conf@hotmail.com");
			
			// Commit the update
			session.getTransaction().commit();
			
			// Start a new session
			session = sessionFactory.getCurrentSession();
			
			// Begin another transaction
			session.beginTransaction();
			
			// Execute update query
			System.out.println("Updating the student with id: 7");
			session.createQuery("update Student set firstName = 'Augustus', lastName = 'Caesar' where id = 7")
									.executeUpdate();
			
			// Commit transactiýon
			session.getTransaction().commit();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}

}
