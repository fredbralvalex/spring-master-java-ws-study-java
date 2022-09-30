package com.fbaa.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fbaa.rest.webservices.restfulwebservices.jpa.UserRepository;

import jakarta.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/jpa")
public class UserJpaResource {
	
	private UserRepository repository;
	
	public UserJpaResource(UserRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers () {
		return repository.findAll();		
	}
	
	@GetMapping("/users/{userId}")
	public EntityModel<User> retrieveOneUser (@PathVariable Integer userId) {
		Optional<User> user = repository.findById(userId);
		if (user == null) {
			throw new UserNotFoundException("User Not Found: " + userId);
		}
		
		EntityModel<User> userModel = EntityModel.of(user.get());
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		userModel.add(link.withRel("all-users"));
		
		return userModel;
	}

	@DeleteMapping("/users/{userId}")
	public void deleteOneUser (@PathVariable Integer userId) {
		repository.deleteById(userId);
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser (@Valid @RequestBody User user) {
		User newUser = repository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(newUser.getId())
				.toUri();
		//		ResponseEntity.status(HttpStatus.CREATED).body(null);
		return ResponseEntity.created(location).build();
	}
}
