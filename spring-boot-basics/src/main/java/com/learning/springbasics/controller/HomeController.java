package com.learning.springbasics.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.springbasics.model.User;

@RestController
public class HomeController {
	@GetMapping("/")
	public String home() {
		return "Hello World!";
	}

	@GetMapping("/user")
	public User user() {
		User user = new User();
		user.setId("1");
		user.setName("Iran");
		user.setEmailId("iram@gmail.com");
		return user;
	}
}
