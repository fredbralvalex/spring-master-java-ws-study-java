package com.fbaa.springboot.learnjpahibernate.course;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//name="course"
@Entity
public class Course {
	
	@Id
	private long id;
	
//	@Column(name="name") it doesnt need because it has the same name
	private String name;
	
//	@Column(name="author") it doesnt need because it has the same name
	private String author;
	
	public Course() {
	}
	
	public Course(long id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAuthor() {
		return author;
	}


	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
	}

	
}
