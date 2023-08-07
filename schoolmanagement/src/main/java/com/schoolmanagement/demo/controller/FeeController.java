package com.schoolmanagement.demo.controller;

import java.util.List;
import java.util.Optional;

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

import com.schoolmanagement.demo.entity.Bus;
import com.schoolmanagement.demo.entity.Fee;
import com.schoolmanagement.demo.repository.FeeRepo;

import com.schoolmanagement.demo.service.FeeService;

@RestController
@RequestMapping("/fee")
@CrossOrigin(origins="*")
public class FeeController {

	@Autowired
	private FeeRepo feeRepo;
	@Autowired
	private FeeService feeService;
	@GetMapping("/")
	public  String viewHomePage(@RequestBody Fee fee){
	    return "fee";
	}
	  @PostMapping("/add")
	    public ResponseEntity<Fee>addFee( @RequestBody Fee fee){
	        Fee addFee=this.feeService.addFee(fee);
	        return new ResponseEntity<>(addFee, HttpStatus.CREATED);
	    }
	@PostMapping ("/saveFee")
	public ResponseEntity<Fee> saveFee(@RequestBody Fee fee) {
	   Fee savedFee = feeService.saveFee(fee);
	   return ResponseEntity.ok(savedFee);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Fee> updateFee(@RequestBody Fee fee, @PathVariable Long id) {
	      Fee updated = feeService.updateFee(fee, id);
	      return ResponseEntity.ok(updated);
	  }
	@GetMapping("/getFeeById/{id}")
	public  ResponseEntity<Fee> getFeeById(@PathVariable Long id){
	    return ResponseEntity.ok(this.feeService.getFeeById(id));
	}
	@GetMapping("/getAllFee")
	public  ResponseEntity<List<Fee>> getAllFee(){
	      return ResponseEntity.ok(this.feeService.getAllFee());
	}
	@DeleteMapping("delete/{id}")
	  public ResponseEntity deleteFeeById(@PathVariable Long id){
		    return ResponseEntity.status(HttpStatus.OK).body(feeService.deleteFeeById(id));
	}
	
}
