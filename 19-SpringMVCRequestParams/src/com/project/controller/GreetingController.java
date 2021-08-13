package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/greetings")
public class GreetingController {
	
	@RequestMapping("/form")
	public String getFormPage() {
		return "greeting-form";
	}
	
	@RequestMapping("/result")
	public String getResultPage(@RequestParam String greetingName, Model model) {
		model.addAttribute("greetingName", greetingName);
		return "greeting-result";
	}
}
