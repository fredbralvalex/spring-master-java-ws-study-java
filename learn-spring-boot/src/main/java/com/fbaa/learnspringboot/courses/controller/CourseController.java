package com.fbaa.learnspringboot.courses.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bean.Course;

@RequestMapping("/")
@RestController
public class CourseController {
	
	List<Course> list =  List.of(new Course(1, "Learn Microservices I", "in28minutes"), new Course(2, "Learn FS with Angular and React", "in28minutes"));
	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		return list;
	}
	
	@GetMapping("/courses/{courseId}")
	public Course getCourseDetails (@PathVariable long courseId) {
		return list.stream().filter(course -> course.getId() == courseId).findFirst().get();
	}

}
