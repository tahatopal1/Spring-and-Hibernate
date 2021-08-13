package com.project.process;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.entity.Course;
import com.project.entity.Instructor;
import com.project.entity.InstructorDetail;
import com.project.entity.Review;

public class DeleteDetailDemo {

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
			int instructorId = 6;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, instructorId);
			
			// Display the instructor
			System.out.println("InstructorDetail what will be deleted: " + instructorDetail);
			
			// Cut the tie to remove instructor detail without removing instructor
			instructorDetail.getInstructor().setInstructorDetail(null);
			
			// Delete the instructor detail
			session.delete(instructorDetail);
			
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
