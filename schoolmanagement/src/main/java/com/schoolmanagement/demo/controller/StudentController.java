package com.schoolmanagement.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.schoolmanagement.demo.entity.Student;
import com.schoolmanagement.demo.exception.UserNotFoundException;
import com.schoolmanagement.demo.payloads.ApiResponse;
import com.schoolmanagement.demo.repository.StudentRepo;
import com.schoolmanagement.demo.service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "*")
public class StudentController {

	@Autowired
	private StudentRepo studentRepo;
	@Autowired 
	private StudentService studentService;
	
//	 @GetMapping("/")
//	    public  String viewHomePage(@RequestBody Student student){
//	        return "student";
//	    }
//	    @GetMapping("/")
//	    public  String viewHomePage(Model model){
//	        return findPaginated(1, model);
//	    }
	@PostMapping("/add")
	 public ResponseEntity<?> addStudent(@RequestBody Student student){
		Student existingStudent = studentRepo.findByRollNumber(student.getRollNumber());
		if (existingStudent == null) {
			studentRepo.save(student);
			return ResponseEntity.ok(student);
			
		} 
		return ResponseEntity.badRequest().body(student);
    }



	@PostMapping ("/saveStudent")
	 public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        Student savedStudent = studentService.saveStudent(student);
        return ResponseEntity.ok(savedStudent);
    }
	
	@GetMapping("/getStudentById/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok().body(student);
    }
	  @PutMapping("update/{id}")
	  public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable Long id) {
	        Student updated = studentService.updateStudent(student, id);
	        return ResponseEntity.ok(updated);
	    }
	  @GetMapping("/getAllStudents")
	  public  ResponseEntity<List<Student>> getAllStudents(){
	        return ResponseEntity.ok(this.studentService.getAllStudents());
	  }
	  @DeleteMapping("deleteStudent/{id}")
	    public ResponseEntity deleteStudent(@PathVariable Long id){
		    return ResponseEntity.status(HttpStatus.OK).body(studentService.deleteStudentById(id));
	  }
	  
	
	  @GetMapping("/page")
	   public ResponseEntity<Map<String, Object>> findPaginated(
	            @RequestParam(value = "page", defaultValue = "1") int pageNo,
	            @RequestParam(value = "pageSize", defaultValue = "5") int pageSize
	    ) {
	        Page<Student> page = studentService.findPaginated(pageNo, pageSize);
	        List<Student> studentList = page.getContent();
	       
	        long totalItems = page.getTotalElements();
	        int totalPages = page.getTotalPages();
	        
	        Map<String, Object> response = new HashMap<>();
	        response.put("data", studentList);
	        response.put("totalPages", totalPages);
	        response.put("totalItems", totalItems);

	        return ResponseEntity.ok(response);
	    }
}
