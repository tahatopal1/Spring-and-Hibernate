package com.project.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.entity.Student;

public class QueryStudent {
	
	
	public static void main(String[] args) {
		
		// Create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure()
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// Create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			// Start transaction
			session.beginTransaction();
			
			// Get all students
			List<Student> students = session.createQuery("from Student").list();
			
			// Print students
			System.out.println("Print all");
			listStudents(students);
			
			// Get all students whose name or surname includes 'on'
			System.out.println("Print includes on");
			students = session.createQuery("from Student s where s.firstName like '%on%' or s.lastName like '%on%'").list();
			
			// Print students
			listStudents(students);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}
	
	public static void listStudents(List<Student> students) {
		students.stream().forEach(System.out::println);
	}
}
