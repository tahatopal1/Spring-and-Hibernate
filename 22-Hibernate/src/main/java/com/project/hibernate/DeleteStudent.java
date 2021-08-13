package com.project.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.entity.Student;

public class DeleteStudent {

	public static void main(String[] args) {
		
		// Create a session factory
		SessionFactory sessionFactory = new Configuration()
				.configure()
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// Create a session
		Session session = sessionFactory.getCurrentSession();
		
		// Define a student id
		int studentId = 8;
		
		try {
			
			// Start transaction
			session.beginTransaction();
			
			// Get the student
			Student student = session.get(Student.class, studentId);
			
			// Delete the student using by student object
			session.delete(student);
			
			// Delete another record using by query
			session.createQuery("delete Student s where s.lastName = 'Confucius'").executeUpdate();
			
			// Commit transaction
			session.getTransaction().commit();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			// Close session
			session.close();
			
			// Close sessionFactory
			sessionFactory.close();
		}
	}

}
