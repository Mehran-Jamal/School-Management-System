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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolmanagement.demo.entity.Holiday;
import com.schoolmanagement.demo.entity.Student;
import com.schoolmanagement.demo.repository.HolidayRepo;
import com.schoolmanagement.demo.service.HolidayService;

@RestController
@RequestMapping("/holiday")
@CrossOrigin(origins="*")
public class HolidayController {
	@Autowired
	private HolidayService holidayService;
	@Autowired
	private HolidayRepo holidayRepo;
	
	
	@PostMapping("/add")
	 public ResponseEntity<?> addHoliday(@RequestBody Holiday holiday){
		Holiday existingHoliday = holidayRepo.findByDate(holiday.getDate());
		if (existingHoliday == null) {
			holidayRepo.save(holiday);
			return ResponseEntity.ok(holiday);
			
		} 
		return ResponseEntity.badRequest().body(holiday);
   }
	
	@PostMapping ("/saveHoliday")
	 public ResponseEntity<Holiday> saveHoliday(@RequestBody Holiday holiday) {
       Holiday savedHoliday = holidayService.saveHoliday(holiday);
       return ResponseEntity.ok(savedHoliday);
   }
	
	@GetMapping("/getHolidayById/{id}")
   public ResponseEntity<Holiday> getHolidayById(@PathVariable Long id) {
       Holiday holiday = holidayService.getHolidayById(id);
       return ResponseEntity.ok().body(holiday);
   }
	  @GetMapping("/getAllHolidays")
	  public  ResponseEntity<List<Holiday>> getAllHoliday(){
	        return ResponseEntity.ok(this.holidayService.getAllHoliday());
	  }
	  @DeleteMapping("deleteHoliday/{id}")
	    public ResponseEntity deleteHoliday(@PathVariable Long id){
		    return ResponseEntity.status(HttpStatus.OK).body(holidayService.deleteHolidayById(id));
	  }
	  
}
