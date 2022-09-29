package com.fbaa.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

	//URI - Twitter
	@GetMapping("/v1/person")
	public PersonV1 getFirstVersionOfPerson() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionOfPerson() {
		Name name = new Name( "Bob", "Charlie");
		return new PersonV2(name);
	}
	
	//path Param - Amazon
	@GetMapping(path="/person", params="version=1")
	public PersonV1 getFirstVersionOfPersonRequestParam() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path="/person", params="version=2")
	public PersonV2 getSecondVersionOfPersonRequestParam() {
		Name name = new Name( "Bob", "Charlie");
		return new PersonV2(name);
	}
	
	//Header X-API-VERSION - Microsoft
	@GetMapping(path="/person/header", headers="X-API-VERSION=1")
	public PersonV1 getFirstVersionOfPersonRequestHeader() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path="/person/header", headers="X-API-VERSION=2")
	public PersonV2 getSecondVersionOfPersonRequestHeader() {
		Name name = new Name( "Bob", "Charlie");
		return new PersonV2(name);
	}
	
	//Header Accept - GitHub
	@GetMapping(path="/person/accept", produces="application/vnd.company.app-v1+json")
	public PersonV1 getFirstVersionOfPersonAcceptHeader() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path="/person/accept", produces="application/vnd.company.app-v2+json")
	public PersonV2 getSecondVersionOfPersonAcceptHeader() {
		Name name = new Name( "Bob", "Charlie");
		return new PersonV2(name);
	}
}
