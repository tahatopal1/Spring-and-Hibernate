package com.project.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.project.validation.RoleCode;

public class Member {
	
	@NotNull(message = "cannot be null")
	@Size(min = 2, message = "Must be at least 2 characters!")
	private String name;
	
	@NotNull(message = "cannot be null")
	@Size(min = 2, message = "Must be at least 2 characters!")
	private String surname;
	
	@NotNull(message = "cannot be null")
	@Min(value = 18, message = "Must be over 18")
	private Integer age;
	
	@NotNull(message = "cannot be null")
	@Pattern(regexp = "^[A-Za-z0-9]{5}", message = "Must be at least 5 digits/chars")
	private String memberCode;
	
	@RoleCode(value = "DRC", message = "Must start with DRC")
	private String roleCode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	
	
}
