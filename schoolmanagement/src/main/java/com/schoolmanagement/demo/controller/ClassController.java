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

import com.schoolmanagement.demo.entity.ClassName;
import com.schoolmanagement.demo.entity.Student;
import com.schoolmanagement.demo.repository.ClassRepo;
import com.schoolmanagement.demo.service.ClassService;

@RestController
@RequestMapping("/class")
@CrossOrigin(origins = "*")
public class ClassController {
	@Autowired
	private ClassRepo classRepo;
	@Autowired
	private ClassService classService;
	 @GetMapping("/")
	    public  String viewHomePage(@RequestBody ClassName className){
	        return "classNAme";
	    }
		@PostMapping("/add")
		 public ResponseEntity<String> addStudent(@RequestBody ClassName className){
			Student existingStudent = classRepo.findByClassName(className.getClassName());
			if (existingStudent == null) {
				classRepo.save(className);
				return ResponseEntity.ok("Student saved with Id" + className.getClassName());
				
			} 
			return ResponseEntity.badRequest().body("Already exists");
	    }
		@PostMapping ("/saveClass")
		 public ResponseEntity<ClassName> saveClassName(@RequestBody ClassName className) {
	        ClassName savedClassName = classService.saveClass(className);
	        return ResponseEntity.ok(savedClassName);
	    }
		@GetMapping("/getClassById/{id}")
		public  ResponseEntity<ClassName> getStudentById(@PathVariable Long id){
	        return ResponseEntity.ok(this.classService.getClassById(id));
	  }
		  @PutMapping("update/{id}")
		  public ResponseEntity<ClassName> updateClass(@RequestBody ClassName className, @PathVariable Long id) {
		        ClassName updated = classService.updateclass(className, id);
		        return ResponseEntity.ok(updated);
		    }
		  @GetMapping("/getAllClass")
		  public  ResponseEntity<List<ClassName>> getAllClassNames(){
		        return ResponseEntity.ok(this.classService.getAllClassNames());
		  }
		  @DeleteMapping("delete/{id}")
		    public ResponseEntity deleteStudent(@PathVariable Long id){
			    return ResponseEntity.status(HttpStatus.OK).body(classService.deleteClassNameById(id));
		  }
		
}
