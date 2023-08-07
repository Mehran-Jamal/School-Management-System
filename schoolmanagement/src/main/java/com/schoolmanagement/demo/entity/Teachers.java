package com.schoolmanagement.demo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Teachers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String qualification;
	private String age;
	private Long number;
	
	@ManyToMany
	@JoinColumn(name="classname_id")
	private List<ClassName> classNames;

	public Teachers() {
		
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

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public List<ClassName> getClassNames() {
		return classNames;
	}

	public void setClassNames(List<ClassName> classNames) {
		this.classNames = classNames;
	}

	@Override
	public String toString() {
		return "Teachers [id=" + id + ", name=" + name + ", qualification=" + qualification + ", age=" + age
				+ ", number=" + number + ", classNames=" + classNames + "]";
	}
	
	
}
