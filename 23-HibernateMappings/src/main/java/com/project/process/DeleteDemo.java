package com.project.process;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.entity.Course;
import com.project.entity.Instructor;
import com.project.entity.InstructorDetail;
import com.project.entity.Review;

public class DeleteDemo {

	public static void main(String[] args) {
		
		// Create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		
		// Craete session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			// Start transaction
			session.beginTransaction();
			
			// Get the instructor
			int instructorId = 3;
			Instructor instructor = session.get(Instructor.class, instructorId);
			
			// Display the instructor
			System.out.println("Instructor what will be deleted: " + instructor.toString());
			
			// Delete the instructor
			session.delete(instructor);
			
			// Commit the transaction
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}

}
