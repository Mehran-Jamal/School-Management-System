package com.schoolmanagement.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolmanagement.demo.entity.ClassName;
import com.schoolmanagement.demo.entity.Student;
import com.schoolmanagement.demo.repository.ClassRepo;
import com.schoolmanagement.demo.repository.StudentRepo;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin(origins = "*")
public class DashboardController {
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private ClassRepo classRepo;
	
	@GetMapping("/")
	public  ResponseEntity<HashMap<String, Integer>> getStudentById(){
		System.err.println("total Student"+ studentRepo.findAll().size());
		System.err.println("total Classes"+ classRepo.findAll().size());
		HashMap<String, Integer> response = new HashMap<>();
		response.put("totalStudents", studentRepo.findAll().size());
		response.put("totalClasses", classRepo.findAll().size());
        return ResponseEntity.ok(response);
  }

}
