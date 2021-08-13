package com.project.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.entity.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public User findByUserName(String userName) {
		
		// Get the current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		// Retrieve/read from database using username
		Query<User> query = session.createQuery("from User where userName = :name", User.class);
		query.setParameter("name", userName);
		
		User user = null;
		try {
			user = query.getSingleResult();
		} catch (Exception e) {
			user = null;
		}
		
		return user;
	}

	@Override
	public void save(User user) {
		
		// Get the current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		// User creation
		session.saveOrUpdate(user);
	}

}
