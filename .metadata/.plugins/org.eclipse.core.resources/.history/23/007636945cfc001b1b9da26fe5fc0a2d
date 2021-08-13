package com.project.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.project.entity.User;
import com.project.model.CrmUser;

public interface UserService extends UserDetailsService{
	
	public User findByUserName(String userName);
	
	public void save(CrmUser crmUser);
}
