package com.project.controller;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.model.Member;

@Controller
public class MemberController {
	
	@InitBinder // InitBinder is the pre-processor. Rearranges the web requests.
	public void initBinder(WebDataBinder webDataBinder) {
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		webDataBinder.registerCustomEditor(String.class, editor);
	}
	
	@RequestMapping("/")
	public String getMemberFormPage(Model model) {
		model.addAttribute("member", new Member());
		return "member-form";
	}
	
	@RequestMapping("/memberResult")
	public String getMemberResultPage(@Valid @ModelAttribute Member member, BindingResult bindingResult) {
		
		// Logging
		System.out.println("Member name: " + member.getName());
		System.out.println("Member surname: " + member.getSurname());
		
		if (bindingResult.hasErrors()) {
			// Logging for binding result
			System.out.println("Binding result: " + bindingResult);
			return "member-form";
		}
		
		return "member-result";
	}
	
}
