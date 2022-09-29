package com.fbaa.springboot.learnjpahibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fbaa.springboot.learnjpahibernate.course.Course;

@Repository
public class CourseJdbcRepository {

	@Autowired
	private JdbcTemplate springJdbcTemplate;
	
	private static final String INSERT_QUERY = 
			"""
		
					insert into course (id, name, author) values (?, ?, ?);
	
			""";
	
	private static final String DELETE_QUERY = 
			"""
		
					delete from course where id=?;
	
			""";
	
	public void insert(Course course) {
		springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
	}

	public void delete(long courseId) {
		springJdbcTemplate.update(DELETE_QUERY, courseId);
	}
}
