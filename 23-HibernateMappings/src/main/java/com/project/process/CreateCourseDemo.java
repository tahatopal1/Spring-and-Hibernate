package com.project.process;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.entity.Course;
import com.project.entity.Instructor;
import com.project.entity.InstructorDetail;
import com.project.entity.Learner;
import com.project.entity.Review;

public class CreateCourseDemo {

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
			
			// Begin transaction
			session.beginTransaction();
			
			// Retrieve the instructor with id is 14
			Instructor instructor = session.get(Instructor.class, 14);
			
			// Create course objects
			Course course1 = new Course("Physics");
			Course course2 = new Course("Music");
			
			// Add courses to instructor
			instructor.add(course1);
			instructor.add(course2);
			
			// Save the courses
			session.save(course1);
			session.save(course2);
			
			// Commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}

}
