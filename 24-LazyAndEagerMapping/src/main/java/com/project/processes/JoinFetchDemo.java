package com.project.processes;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.project.entity.BusinessDomain;
import com.project.entity.BusinessTech;
import com.project.entity.Developer;

public class JoinFetchDemo {
	public static void main(String[] args) {
		
		// Create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure()
				.addAnnotatedClass(Developer.class)
				.addAnnotatedClass(BusinessTech.class)
				.addAnnotatedClass(BusinessDomain.class)
				.buildSessionFactory();
		
		// Create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			// Start transaction
			session.beginTransaction();
			
			// Get the developer with id 6 by using query
			// This is another way to prevent lazy loading issue
			Query<Developer> query = session.createQuery("select d from Developer d "
					.concat("JOIN FETCH d.businessTechList ")
					.concat("where d.id = :developerId"), Developer.class);
					
			// Set parameter on query
			query.setParameter("developerId", 6);
			
			// Get the instructor
			Developer developer = query.getSingleResult();
			
			// Commit transaction
			session.getTransaction().commit();
			
			// Fetching data after transaction/session is over
			developer.getBusinessTechList().stream().forEach(System.out::println);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			session.close();
			sessionFactory.close();
		}
	}
}
