package com.project.process;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.entity.Course;
import com.project.entity.Instructor;
import com.project.entity.InstructorDetail;
import com.project.entity.Learner;
import com.project.entity.Review;

public class DeleteCourseAndReviewDemo {

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

			// Get the course with id 19
			Course course = session.get(Course.class, 19);

			// Print the course
			System.out.println(course);

			// Print the reviews
			course.getReviews().stream().forEach(System.out::println);

			// Delete the course (associtated reviews with the course will be deleted aswell)
			session.delete(course);

			// Commit transaction
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// Close the session
			session.close();

			// Close the session factory
			sessionFactory.close();
		}

	}

}
