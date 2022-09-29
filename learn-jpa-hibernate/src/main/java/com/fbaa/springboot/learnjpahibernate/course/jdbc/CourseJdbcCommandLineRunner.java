package com.fbaa.springboot.learnjpahibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fbaa.springboot.learnjpahibernate.course.Course;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

	@Autowired
	private CourseJdbcRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		Course course = new Course(1, "Learn AWS Now", "In 28 Minutes Now");
		Course course2 = new Course(2, "Learn Azure Now", "In 28 Minutes Now");
		Course course3 = new Course(3, "Learn Devops Now", "In 28 Minutes Now");
		repository.insert(course);
		repository.insert(course2);
		repository.insert(course3);
		
		repository.delete(2);
		
	}

}
