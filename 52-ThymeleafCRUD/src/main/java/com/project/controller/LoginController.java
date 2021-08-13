package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login() {
		return "login/login";
	}
	
	@GetMapping("/access-denied")
	public String accessDenied() {
		return "login/access-denied";
	}
}
