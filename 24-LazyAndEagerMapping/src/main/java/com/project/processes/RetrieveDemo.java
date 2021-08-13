package com.project.processes;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.entity.BusinessDomain;
import com.project.entity.BusinessTech;
import com.project.entity.Developer;

public class RetrieveDemo {

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
			
			// Get the developer with id 6
			Developer developer = session.get(Developer.class, 6);
			
			// Commit transaction
			session.getTransaction().commit();
			
			List<BusinessDomain> businessDomains = developer.getBusinessDomainList(); // It won't fail, eager loader
			List<BusinessTech> businessTechs = developer.getBusinessTechList(); // It will fail, lazy loader 
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			session.close();
			sessionFactory.close();
		}

	}

}
