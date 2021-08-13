package com.project.process;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.entity.Course;
import com.project.entity.Instructor;
import com.project.entity.InstructorDetail;
import com.project.entity.Learner;
import com.project.entity.Review;

public class CreateCourseAndStudentDemo {

	public static void main(String[] args) {
		
		// Create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure()
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Learner.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		// Create session
		Session session = sessionFactory.getCurrentSession();
		
		
		try {
			
			// Start transaction
			session.beginTransaction();
			
			//Create course object
			Course course = new Course("Boxing");
			
			// Save the course
			session.save(course);
			
			// Create learner objects
			Learner learner = new Learner("Khabib", "Nurmagomedov", "khabib@mail.co");
			Learner learner1 = new Learner("Connor", "McGregor", "conor@mail.co");
			
			// Add learners into course
			course.addLearner(learner);
			course.addLearner(learner1);
			
			// Save learners
			session.save(learner);
			session.save(learner1);
			
			// Commit transaction
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			// Close session
			session.close();
			
			// Close session factory
			sessionFactory.close();
		}
	}

}
