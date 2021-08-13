package com.project.process;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.entity.Course;
import com.project.entity.Instructor;
import com.project.entity.InstructorDetail;
import com.project.entity.Review;

public class CreateCourseAndReviewDemo {

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
			
			// Create the course
			Course course = new Course("Design");
			
			// Create reviews
			Review review  = new Review("Good work!");
			Review review1 = new Review("Thank you for your effort!");
			Review review2 = new Review("What a terrible course, i gave it 1 star!");
			
			// Add reviews into course
			course.addReview(review);
			course.addReview(review1);
			course.addReview(review2);
			
			// Save the course (and the reviews aswell by cascading)
			session.save(course);
			
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
