package com.project.process;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.entity.Course;
import com.project.entity.Instructor;
import com.project.entity.InstructorDetail;
import com.project.entity.Learner;
import com.project.entity.Review;

public class AddInstructorToCourse {
	
	public static void main(String[] args) {
		
		// Create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Learner.class)
				.buildSessionFactory();
		
		// Create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			// Start transaction
			session.beginTransaction();
			
			// Get the course
			Course course = session.get(Course.class, 25);
			
			// Get the instructor
			Instructor instructor = session.get(Instructor.class, 11);
			
			// Add instructor to course
			course.setInstructor(instructor);
			
			// Commit transaction
			session.getTransaction().commit();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			// Close the session
			session.close();
			
			// Close the session factory
			sessionFactory.close();
		}
	}
	
}
