package com.curso.springboot.exceptions;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.curso.springboot.exceptions.models.domain.User;

@Configuration
public class ExceptionConfig {
	
	@Bean
	public List<User> users()
	{
		 List<User> users = Arrays.asList(new User(1L, "Jose", "Gonzalez"),
				new User(2L, "Luis", "Perez"),new User(3L, "Andres", "Gomez"),
				new User(4L, "Jorge", "Ramirez"), new User(5L, "Andrea", "Velez"));
		
		return users;
		
	}
	

}
