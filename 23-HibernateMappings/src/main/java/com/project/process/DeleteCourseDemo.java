package com.project.process;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.entity.Course;
import com.project.entity.Instructor;
import com.project.entity.InstructorDetail;
import com.project.entity.Review;

public class DeleteCourseDemo {
	public static void main(String[] args) {
		
		// Create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		
		// Create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			// Start transaction
			session.beginTransaction();
			
			// Get course - with id is 10
			Course course = session.get(Course.class, 10);
			
			// Delete the course
			session.delete(course);
			
			// Commit transaction
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}

}
