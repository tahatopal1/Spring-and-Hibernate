package com.project.dao;

import com.project.entity.User;

public interface UserDao {
	
	public User findByUserName(String userName);
	
	public void save(User user);
}
