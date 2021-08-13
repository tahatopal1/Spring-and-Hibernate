package com.project.dao;

import com.project.entity.Role;

public interface RoleDao {
	
	public Role findRoleByName(String roleName);
	
}
