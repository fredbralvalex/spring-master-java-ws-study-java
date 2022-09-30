package com.fbaa.springboot.learnjpahibernate.course.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fbaa.springboot.learnjpahibernate.course.Course;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long>{

	List<Course> findByAuthor(String author);

	List<Course> findByName(String name);
	
}
