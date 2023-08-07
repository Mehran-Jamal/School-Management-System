package com.schoolmanagement.demo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@ManyToMany
	@JoinColumn(name="teachers_id")
	private List<Teachers> teachers;

	public Subject() {
		
	}

	public Subject(Long id, String name, List<Teachers> teachers) {
		super();
		this.id = id;
		this.name = name;
		this.teachers = teachers;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Teachers> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teachers> teachers) {
		this.teachers = teachers;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", teachers=" + teachers + "]";
	}

	

	
	
}
