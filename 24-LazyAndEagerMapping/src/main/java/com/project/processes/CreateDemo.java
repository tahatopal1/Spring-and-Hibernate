package com.project.processes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.project.entity.BusinessDomain;
import com.project.entity.BusinessTech;
import com.project.entity.Developer;

public class CreateDemo {

	
	// We will create records for all tables in this file
	
	public static void main(String[] args) {

		// Create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure()
				.addAnnotatedClass(Developer.class)
				.addAnnotatedClass(BusinessDomain.class)
				.addAnnotatedClass(BusinessTech.class)
				.buildSessionFactory();
		
		// Create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			// Start transaction
			session.beginTransaction();
			
			//Create developer
			Developer developer = new Developer("James", "Gosling");
			
			// Save developer
			session.save(developer);
			
			// Create techs
			BusinessTech tech1 = new BusinessTech("Java", 1995);
			BusinessTech tech2 = new BusinessTech("JavaScript", 1995);
			BusinessTech tech3 = new BusinessTech("Hibernate", 2009);
			
			// Create domains
			BusinessDomain domain1 = new BusinessDomain("Technology");
			BusinessDomain domain2 = new BusinessDomain("Software");
			
			// Add techs to developer
			developer.addTech(tech1);
			developer.addTech(tech2);
			developer.addTech(tech3);
			
			// Add domains to developer
			developer.addDomain(domain1);
			developer.addDomain(domain2);
			
			// Save techs
			session.save(tech1);
			session.save(tech2);
			session.save(tech3);
			
			// Save domains
			session.save(domain1);
			session.save(domain2);
			
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
