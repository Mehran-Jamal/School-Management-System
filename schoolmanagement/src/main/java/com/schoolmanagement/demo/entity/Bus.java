package com.schoolmanagement.demo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Bus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private Long busNumber;
     private String driverName;
     private String capacity;
     
     @OneToMany(mappedBy = "bus")
     private List<Student> student;
     
     

	public Bus() {
		
	}

	public Bus(Long id, Long busNumber, String driverName, String capacity, List<Student> student) {
		super();
		this.id = id;
		this.busNumber = busNumber;
		this.driverName = driverName;
		this.capacity = capacity;
		this.student = student;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(Long busNumber) {
		this.busNumber = busNumber;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Bus [id=" + id + ", busNumber=" + busNumber + ", driverName=" + driverName + ", capacity=" + capacity
				+ ", student=" + student + "]";
	}
     
     
}
