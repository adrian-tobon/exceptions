package com.curso.springboot.exceptions.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.curso.springboot.exceptions.exceptions.UserNotFoundException;
import com.curso.springboot.exceptions.models.domain.User;

@Service
public class UserServiceImpl implements UserService{

	
	private List<User> users;
	
	
	public UserServiceImpl() {
		
		this.users = Arrays.asList(new User(1L, "Jose", "Gonzalez"),
				new User(2L, "Luis", "Perez"),new User(3L, "Andres", "Gomez"),
				new User(4L, "Jorge", "Ramirez"), new User(5L, "Andrea", "Velez"));
		
	}

	/*@Override
	public User findById(Long id) {			
		
		return users.stream().filter(u -> u.getId().equals(id)).findFirst()
				.orElseThrow(() -> new UserNotFoundException("Error: user not found"));
		
	}*/
	
	@Override
	public Optional<User> findById(Long id) {			
		
		return Optional.ofNullable(users.stream().filter(u -> u.getId().equals(id)).findFirst()
				.orElseThrow(() -> new UserNotFoundException("Error: user not found")));
		
		/*User user = null;
		for(User u : users) {
			if(u.getId().equals(id))
			{
				user = u;
				break;
			}			
		}
		
		return Optional.ofNullable(user);*/
		
	}

	@Override
	public List<User> findAll() {		
		return users;
	}

}
