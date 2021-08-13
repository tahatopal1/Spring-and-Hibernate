package com.project.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.model.Car;

@Controller
public class CarController {
	
	// Options with properties file
	@Value("#{colors}")
	private Map<String, String> colors;
	
	@RequestMapping("/")
	public String getCarFormPage(Model model) {
		model.addAttribute("car", new Car());
		model.addAttribute("colors", colors);
		return "car-form";
	}
	
	@RequestMapping("/carResult")
	public String getCarResultPage(@ModelAttribute Car car) {
		return "car-result";
	}
	
}
