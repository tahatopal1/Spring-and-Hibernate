package com.project.process;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.entity.Course;
import com.project.entity.Instructor;
import com.project.entity.InstructorDetail;
import com.project.entity.Learner;
import com.project.entity.Review;

public class DeleteLearnerDemo {

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
			
			// Get instructor with id 2
			Learner learner = session.get(Learner.class, 1);

			// Delete learner. It will be deleted from join-table. 
			// Courses will remain !!!
			session.delete(learner);
			
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
