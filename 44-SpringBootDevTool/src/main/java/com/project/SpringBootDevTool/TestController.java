package com.project.SpringBootDevTool;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {
	
	@GetMapping("first-method")
	public String firstMethod() {
		return "This is the first method";
	}
	
	// This endpoint will be added after spring boot project has started
	@GetMapping("second-method")
	public String secondMethod() {
		return "This is the second method";
	}
	
}
