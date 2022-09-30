package com.fbaa.springboot.learnjpahibernate.course.jpa;

import org.springframework.stereotype.Repository;

import com.fbaa.springboot.learnjpahibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class CourseJpaRepository {

//	@Autowired
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void insert(Course course) {
		entityManager.merge(course);
	}
	
	public Course findById(long courseId) {
		return entityManager.find(Course.class, courseId);
	}
	
	@Transactional
	public void deleteById(long courseId) {
		Course course = findById(courseId);
		entityManager.remove(course);
	}
}
