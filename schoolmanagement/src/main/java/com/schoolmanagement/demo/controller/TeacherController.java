package com.schoolmanagement.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolmanagement.demo.entity.Fee;
import com.schoolmanagement.demo.entity.Teachers;
import com.schoolmanagement.demo.repository.TeacherRepo;
import com.schoolmanagement.demo.service.TeacherService;

@RestController
@RequestMapping("/teacher")
@CrossOrigin(origins="*")
public class TeacherController {
	
	@Autowired
	private TeacherRepo teacherRepo;
	@Autowired
	private TeacherService teacherService;
	@GetMapping("/")
	public  String viewHomePage(@RequestBody Teachers teachers){
	    return "teacher";
	}
	  @PostMapping("/add")
	    public ResponseEntity<Teachers>addTeacher( @RequestBody Teachers teachers){
	        Teachers addTeacher=this.teacherService.addTeacher(teachers);
	        return new ResponseEntity<>(addTeacher, HttpStatus.CREATED);
	    }
	@PostMapping ("/saveTeacher")
	public ResponseEntity<Teachers> saveTeacher(@RequestBody Teachers teachers) {
	   Teachers savedTeacher = teacherService.saveTeacher(teachers);
	   return ResponseEntity.ok(savedTeacher);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Teachers> updateTeacher(@RequestBody Teachers teachers, @PathVariable Long id) {
		System.err.println(teachers.toString());
	      Teachers updatedTeacher = teacherService.updateTeacher(teachers, id);
	      return ResponseEntity.ok(updatedTeacher);
	  }
	@GetMapping("/getTeacherById/{id}")
	public  ResponseEntity<Teachers> getTeacherById(@PathVariable Long id){
	    return ResponseEntity.ok(this.teacherService.getTeacherById(id));
	}
	@GetMapping("/getAllTeachers")
	public  ResponseEntity<List<Teachers>> getAllTeachers(){
	      return ResponseEntity.ok(this.teacherService.getAllTeachers());
	}
	@DeleteMapping("delete/{id}")
	  public ResponseEntity deleteTeacherById(@PathVariable Long id){
		    return ResponseEntity.status(HttpStatus.OK).body(teacherService.deleteTeacherById(id));
	}
	

}
