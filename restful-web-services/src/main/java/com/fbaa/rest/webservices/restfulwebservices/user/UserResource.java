package com.fbaa.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResource {
	
	private UserDaoService userDaoService;
	
	public UserResource(UserDaoService userDaoService) {
		this.userDaoService = userDaoService;
	}
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers () {
		return userDaoService.findAll();		
	}
	
	@GetMapping("/users/{userId}")
	public User retrieveOneUser (@PathVariable Integer userId) {
		User user = userDaoService.findOne(userId);
		if (user == null) {
			throw new UserNotFoundException("User Not Found: " + userId);
		}
		return user;
	}

	@DeleteMapping("/users/{userId}")
	public void deleteOneUser (@PathVariable Integer userId) {
		userDaoService.deleteOne(userId);
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser (@Valid @RequestBody User user) {
		User newUser = userDaoService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(newUser.getId())
				.toUri();
		//		ResponseEntity.status(HttpStatus.CREATED).body(null);
		return ResponseEntity.created(location).build();
	}
}
