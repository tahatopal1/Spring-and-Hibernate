package com.project.controller;

import java.util.logging.Logger;import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.entity.User;
import com.project.model.CrmUser;
import com.project.service.UserService;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	
	@Autowired
	private UserService userService;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping("/registrationForm")
	public String registration(Model model) {
		model.addAttribute("crmUser", new CrmUser());
		return "registration-form";
	}
	
	@PostMapping("/registration")
	public String processRegistrationForm(@Valid @ModelAttribute("crmUser") CrmUser crmUser, BindingResult bindingResult, Model model) {
		
		String userName = crmUser.getUserName();
		logger.info("Processing registration form for: " + userName);
		
		// Form validation
		if (bindingResult.hasErrors()) {
			return "registration-form";
		}
		
		// Check the database if user already exists
		User existingUser = userService.findByUserName(userName);
		if (existingUser != null) {
			model.addAttribute("crmUser", new CrmUser());
			model.addAttribute("registrationError", "User name already exists.");
			
			logger.warning("User name already exists.");
			return "registration-form";
		}
		
		// Create user account
		userService.save(crmUser);
		
		logger.info("User has been created successfully: " + userName);
		
		return "registration-confirmation";
	}
	
}
