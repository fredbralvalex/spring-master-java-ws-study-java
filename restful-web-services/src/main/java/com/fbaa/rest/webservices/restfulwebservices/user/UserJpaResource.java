package com.fbaa.rest.webservices.restfulwebservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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

import com.fbaa.rest.webservices.restfulwebservices.jpa.PostRepository;
import com.fbaa.rest.webservices.restfulwebservices.jpa.UserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/jpa")
public class UserJpaResource {
	
	private UserRepository userRepository;
	
	private PostRepository postRepository;
	
	public UserJpaResource(UserRepository userRepository, PostRepository postRepository) {
		this.postRepository = postRepository;
		this.userRepository = userRepository;
	}
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers () {
		return userRepository.findAll();		
	}
	
	@GetMapping("/users/{userId}")
	public EntityModel<User> retrieveOneUser (@PathVariable Integer userId) {
		Optional<User> user = userRepository.findById(userId);
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
		userRepository.deleteById(userId);
	}

	@GetMapping("/users/{userId}/posts")
	public List<Post> retrievePostsForUser (@PathVariable Integer userId) {
		Optional<User> user = userRepository.findById(userId);
		if (user == null) {
			throw new UserNotFoundException("User Not Found: " + userId);
		}
		return user.get().getPosts();
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser (@Valid @RequestBody User user) {
		User newUser = userRepository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(newUser.getId())
				.toUri();
		//		ResponseEntity.status(HttpStatus.CREATED).body(null);
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/users/{userId}/posts")
	public ResponseEntity<Post> createPostsForUser (@PathVariable Integer userId, @Valid @RequestBody Post post) {
		Optional<User> user = userRepository.findById(userId);
		if (user == null) {
			throw new UserNotFoundException("User Not Found: " + userId);
		}
		
		post.setUser(user.get());
		Post newPost = postRepository.save(post);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(newPost.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/users/{userId}/posts/{postId}")
	public EntityModel<Post> retrieveOnePostForAUser (@PathVariable Integer userId, @PathVariable Integer postId) {
		Optional<Post> post = postRepository.findById(postId);
		if (post == null) {
			throw new UserNotFoundException(String.format("Post {} for user {} Not Found: ", postId, userId));
		}
		
		EntityModel<Post> postModel = EntityModel.of(post.get());
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrievePostsForUser(userId));
		postModel.add(link.withRel("all-posts-for-user"));
		
		return postModel;
	}
}
