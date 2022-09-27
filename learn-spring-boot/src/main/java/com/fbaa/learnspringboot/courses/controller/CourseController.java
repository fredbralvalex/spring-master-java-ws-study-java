package com.fbaa.learnspringboot.courses.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import bean.Course;

@RestController
public class CourseController {
	
	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		return List.of(new Course(1, "Learn Microservices", "in28minutes"));
	}

}
