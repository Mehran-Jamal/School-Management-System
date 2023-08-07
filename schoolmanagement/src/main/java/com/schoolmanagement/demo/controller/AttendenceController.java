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

import com.schoolmanagement.demo.entity.Attendence;
import com.schoolmanagement.demo.entity.Fee;
import com.schoolmanagement.demo.repository.AttendenceRepo;
import com.schoolmanagement.demo.service.AttendenceService;

;

@RestController
@RequestMapping("/attendence")
@CrossOrigin(origins="*")
public class AttendenceController {
	@Autowired
	private AttendenceRepo attendenceRepo;
	@Autowired
	private AttendenceService attendenceService;
	
	@GetMapping("/")
	public  String viewHomePage(@RequestBody Attendence attendence){
	    return "attendence";
	}
	  @PostMapping("/add")
	    public ResponseEntity<Attendence>addAttendence( @RequestBody Attendence attendence){
	        Attendence addAttendence=this.attendenceService.addAttendence(attendence);
	        return new ResponseEntity<>(addAttendence, HttpStatus.CREATED);
	    }
	@PostMapping ("/saveAttendence")
	public ResponseEntity<Attendence> saveAttendence(@RequestBody Attendence attendence) {
	   Attendence savedAttendence = attendenceService.saveAttendence(attendence);
	   return ResponseEntity.ok(savedAttendence);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Attendence> updateAttendence(@RequestBody Attendence attendence, @PathVariable Long id) {
	      Attendence updated = attendenceService.updateAttendence(attendence, id);
	      return ResponseEntity.ok(updated);
	  }
	@GetMapping("/getAttendenceById/{id}")
	public  ResponseEntity<Attendence> getAttendenceById(@PathVariable Long id){
	    return ResponseEntity.ok(this.attendenceService.getAttendenceById(id));
	}
	@GetMapping("/getAllAttendence")
	public  ResponseEntity<List<Attendence>> getAllAttendence(){
	      return ResponseEntity.ok(this.attendenceService.getAllAttendence());
	}
	@DeleteMapping("delete/{id}")
	  public ResponseEntity deleteAttendenceById(@PathVariable Long id){
		    return ResponseEntity.status(HttpStatus.OK).body(attendenceService.deleteAttendenceById(id));
	}

}
