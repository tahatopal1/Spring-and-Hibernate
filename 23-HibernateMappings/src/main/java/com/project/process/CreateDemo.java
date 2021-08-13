package com.project.process;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.entity.Course;
import com.project.entity.Instructor;
import com.project.entity.InstructorDetail;
import com.project.entity.Learner;
import com.project.entity.Review;

public class CreateDemo {
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
			
			// Create the objects
			Instructor instructor = new Instructor("John", "Smith", "jsmth@mail.com");
			InstructorDetail instructorDetail = new InstructorDetail("jsmth", "Guitar");
			
			Instructor instructor2 = new Instructor("James", "Gosling", "jgosl@mail.com");
			InstructorDetail instructorDetail2 = new InstructorDetail("jgosl", "Coding");
			
			Instructor instructor3 = new Instructor("Bill", "Gates", "billg@mail.com");
			InstructorDetail instructorDetail3 = new InstructorDetail("billg", "Development");
			
			Instructor instructor4 = new Instructor("Elon", "Musk", "elon@mail.com");
			InstructorDetail instructorDetail4 = new InstructorDetail("elon", "Gaming");
			
			// Associate the objects
			instructor.setInstructorDetail(instructorDetail);
			instructor2.setInstructorDetail(instructorDetail2);
			instructor3.setInstructorDetail(instructorDetail3);
			instructor4.setInstructorDetail(instructorDetail4);
			
			// Begin transaction
			session.beginTransaction();
			
			
			// Save the objects
			session.save(instructor);
			session.save(instructor2);
			session.save(instructor3);
			session.save(instructor4);
			
			// Commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// Close the session and the factory
			sessionFactory.close();
			session.close();
		}
		
	}
}
