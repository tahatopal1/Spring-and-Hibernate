package com.project.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.project.validation.FieldMatch;
import com.project.validation.ValidEmail;

@FieldMatch.List({
	@FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match")
})
public class CrmUser {
	
	@NotNull(message = "Username is reqiured!")
	@Size(min = 2, message = "Username must consist of at least 2 characters!")
	private String userName;
	
	@NotNull(message = "Password is reqiured!")
	@Size(min = 7, message = "Password must consist of at least 7 characters!")
	private String password;
	
	@NotNull(message = "Matching password is reqiured!")
	@Size(min = 7, message = "Password must consist of at least 7 characters!")
	private String matchingPassword;
	
	@NotNull(message = "First name is reqiured!")
	@Size(min = 2, message = "First name must consift of at least 2 characters")
	private String firstName;
	
	@NotNull(message = "Last name is reqiured!")
	@Size(min = 2, message = "Last name must consift of at least 2 characters")
	private String lastName;
	
	@ValidEmail
	@NotNull(message = "Email is reqiured!")
	private String email;
	
	public CrmUser() { }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
