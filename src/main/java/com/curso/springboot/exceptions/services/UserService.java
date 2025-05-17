package com.curso.springboot.exceptions.services;

import java.util.List;
import java.util.Optional;

import com.curso.springboot.exceptions.models.domain.User;

public interface UserService {

	//public User findById(Long id);
	public Optional<User> findById(Long id);	
	public List<User> findAll();
	
	
}
