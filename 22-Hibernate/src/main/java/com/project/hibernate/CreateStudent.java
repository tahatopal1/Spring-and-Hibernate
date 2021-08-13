package com.project.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.entity.Student;


public class CreateStudent {

	public static void main(String[] args) {
		
		// Create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure()
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// Create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			// Create a student object
			System.out.println("Creating a new student object...");
			Student student1 = new Student("Napoleon", "Bonaparte", "bona@mail.com");
			Student student2 = new Student("Congsi", "Confucius", "conf@mail.com");
			Student student3 = new Student("Julius", "Caesear", "juli@mail.com");
			
			// Start a transaction
			session.beginTransaction();
			
			// Save the student object
			System.out.println("Saving the student...");
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			// Commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} catch (Exception e) {
			
		}finally {
			session.close();
			sessionFactory.close();
		}
		
	}

}
