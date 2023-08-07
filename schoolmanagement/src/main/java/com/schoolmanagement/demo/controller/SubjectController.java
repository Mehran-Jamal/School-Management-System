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

import com.schoolmanagement.demo.entity.Subject;
import com.schoolmanagement.demo.entity.Teachers;
import com.schoolmanagement.demo.repository.SubjectRepo;
import com.schoolmanagement.demo.service.SubjectService;

@RestController
@RequestMapping("/subject")
@CrossOrigin(origins="*")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;
	@Autowired
	private  SubjectRepo subjectRepo;
	@GetMapping("/")
	public  String viewHomePage(@RequestBody Teachers teachers){
	    return "teacher";
	}
	  @PostMapping("/add")
	    public ResponseEntity<Subject>addSubject( @RequestBody Subject subject){
	        Subject addSubject=this.subjectService.addSubject(subject);
	        return new ResponseEntity<>(addSubject, HttpStatus.CREATED);
	    }
	@PostMapping ("/saveSubject")
	public ResponseEntity<Subject> saveSubject(@RequestBody Subject subject) {
	   Subject savedSubject = subjectService.saveSubject(subject);
	   return ResponseEntity.ok(savedSubject);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Subject> updateSubject(@RequestBody Subject subject, @PathVariable Long id) {
		
	      Subject updatedSubject = subjectService.updateSubject(subject, id);
	      return ResponseEntity.ok(updatedSubject);
	  }
	@GetMapping("/getSubjectById/{id}")
	public  ResponseEntity<Subject> getSubjectById(@PathVariable Long id){
	    return ResponseEntity.ok(this.subjectService.getSubjectById(id));
	}
	@GetMapping("/getAllSubjects")
	public  ResponseEntity<List<Subject>> getAllSubjects(){
	      return ResponseEntity.ok(this.subjectService.getAllSubjects());
	}
	@DeleteMapping("delete/{id}")
	  public ResponseEntity deleteSubjectById(@PathVariable Long id){
		    return ResponseEntity.status(HttpStatus.OK).body(subjectService.deleteSubjectById(id));
	}
	
	

}
