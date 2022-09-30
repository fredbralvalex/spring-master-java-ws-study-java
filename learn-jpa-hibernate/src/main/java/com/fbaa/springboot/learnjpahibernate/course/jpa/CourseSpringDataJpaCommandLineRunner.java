package com.fbaa.springboot.learnjpahibernate.course.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fbaa.springboot.learnjpahibernate.course.Course;
import com.fbaa.springboot.learnjpahibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseSpringDataJpaCommandLineRunner implements CommandLineRunner {

	@Autowired
	private CourseSpringDataJpaRepository repository;
	
	
	@Override
	public void run(String... args) throws Exception {
		Course course = new Course(7, "Learn AWS JPA", "In 28 Minutes Now");
		Course course2 = new Course(8, "Learn Azure JPA", "In 28 Minutes Now");
		Course course3 = new Course(9, "Learn Devops JPA", "In 28 Minutes Now");
		repository.save(course);
		repository.save(course2);
		repository.save(course3);
		
		repository.deleteById(8l);
		
		System.out.println(repository.findById(7l));
		System.out.println(repository.findById(9l));
		
		System.out.println(repository.findAll());
		System.out.println(repository.count());
		
		System.out.println(repository.findByAuthor("In 28 Minutes Now"));
		System.out.println(repository.findByName("Learn AWS JPA"));
	}

}
