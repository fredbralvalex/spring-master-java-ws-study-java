package com.fbaa.springboot.learnjpahibernate.course.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fbaa.springboot.learnjpahibernate.course.Course;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

	@Autowired
	private CourseJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		Course course = new Course(4, "Learn AWS Again", "In 28 Minutes Now");
		Course course2 = new Course(5, "Learn Azure Again", "In 28 Minutes Now");
		Course course3 = new Course(6, "Learn Devops Again", "In 28 Minutes Now");
		repository.insert(course);
		repository.insert(course2);
		repository.insert(course3);
		
		repository.deleteById(5);
		
		System.out.println(repository.findById(4));
		System.out.println(repository.findById(6));
		
	}

}
