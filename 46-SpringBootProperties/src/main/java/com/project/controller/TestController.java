package com.project.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@Value("${coach.name}")
	private String teamCoach;
	
	@Value("${team.name}")
	private String team;
	
	
	@GetMapping("/team")
	public String teamInfo() {
		return "Coach: " + teamCoach + ", Team name: " + team;
	}
}
