package com.curso.springboot.exceptions.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import com.curso.springboot.exceptions.exceptions.UserNotFoundException;
import com.curso.springboot.exceptions.models.domain.User;
import com.curso.springboot.exceptions.services.UserService;

@RestController
@RequestMapping("/app")
public class AppController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String index() {
		int value = Integer.parseInt("casa");
		//int value = 100/0;
		System.out.println(value);
		return "OK 200";
	}
	
	
	/*@GetMapping("/show/{id}")
	public User showUser(@PathVariable Long id) {		
		return userService.findById(id).orElseThrow(() -> new UserNotFoundException("Error: user not found"));
	}*/
	
	@GetMapping("/show/{id}")
	public Optional<User> showUser(@PathVariable Long id) {		
		return userService.findById(id);		
	}
	

}
