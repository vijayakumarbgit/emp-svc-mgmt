package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test/")
public class AppController {
	
	@GetMapping("/app")
	public String  getData()
	{
		return "Testing is successful";
		
	}

}
