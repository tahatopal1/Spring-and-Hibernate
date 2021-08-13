package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	@RequestMapping("/")
	public String getHomePage() {
		return "member-home";
	}
	
	@RequestMapping("/memberForm")
	public String getFormPage() {
		return "member-form";
	}
	
	@RequestMapping("/memberResult")
	public String getResultPage() {
		return "member-result";
	}
	
	
}
