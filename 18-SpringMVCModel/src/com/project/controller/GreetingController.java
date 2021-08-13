package com.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetingController {
	
	@RequestMapping("/")
	public String getGreetingFormPage() {
		return "greeting-form";
	}
	
	
	@RequestMapping("/greetingResult")
	public String getGreetingResultPage(HttpServletRequest request, Model model) {
		
		String name = request.getParameter("greetingInfo");
		model.addAttribute("greetingInfo", name);
		
		return "greeting-result";
	}
	
}
