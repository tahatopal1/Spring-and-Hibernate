package com.project.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.entity.Role;

@Repository
public class RoleDaoImpl implements RoleDao{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Role findRoleByName(String roleName) {
		
		// Get the current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		// Retrieve/read from database using name
		Query<Role> query = session.createQuery("from Role where name = :roleName", Role.class);
		query.setParameter("roleName", roleName);
		
		Role role = null;
		
		try {
			role = query.getSingleResult();
		} catch (Exception e) {
			role = null;
		}
		
		return role;
	}

}
