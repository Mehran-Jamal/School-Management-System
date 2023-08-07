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
import com.schoolmanagement.demo.entity.ClassName;
import com.schoolmanagement.demo.entity.Student;
import com.schoolmanagement.demo.repository.BusRepo;
import com.schoolmanagement.demo.service.BusService;

@RestController
@RequestMapping("/bus")
@CrossOrigin(origins="*")
public class BusController {
@Autowired
private BusRepo busRepo;
@Autowired
private BusService busService;

@GetMapping("/")
public  String viewHomePage(@RequestBody Bus bus){
    return "bus";
}
@PostMapping("/add")
public ResponseEntity<String> addBus(@RequestBody Bus bus){
    Optional<Bus> existingBus = busRepo.findById(bus.getBusNumber());
    if (!existingBus.isPresent()) {
        busRepo.save(bus);
        return ResponseEntity.ok("Bus saved with ID " + bus.getBusNumber());
    } 
    return ResponseEntity.badRequest().body("Bus with the same ID already exists");
}

@PostMapping ("/saveBus")
public ResponseEntity<Bus> saveBus(@RequestBody Bus bus) {
   Bus savedBus = busService.saveBus(bus);
   return ResponseEntity.ok(savedBus);
}
@PutMapping("/update/{id}")
public ResponseEntity<Bus> updateBus(@RequestBody Bus bus, @PathVariable Long id) {
      Bus updated = busService.updateBus(bus, id);
      return ResponseEntity.ok(updated);
  }
@GetMapping("/getBusById/{id}")
public  ResponseEntity<Bus> getBusById(@PathVariable Long id){
    return ResponseEntity.ok(this.busService.getBusById(id));
}
@GetMapping("/getAllBusses")
public  ResponseEntity<List<Bus>> getAllBusses(){
      return ResponseEntity.ok(this.busService.getAllBusses());
}
@DeleteMapping("delete/{id}")
  public ResponseEntity deleteStudent(@PathVariable Long id){
	    return ResponseEntity.status(HttpStatus.OK).body(busService.deleteBusById(id));
}
}
