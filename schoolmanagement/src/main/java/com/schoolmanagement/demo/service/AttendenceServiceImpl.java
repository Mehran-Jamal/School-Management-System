package com.schoolmanagement.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolmanagement.demo.entity.Attendence;
import com.schoolmanagement.demo.entity.Fee;
import com.schoolmanagement.demo.repository.AttendenceRepo;
@Service
public class AttendenceServiceImpl implements AttendenceService{

	@Autowired
	private AttendenceRepo attendenceRepo;
	@Override
	public Attendence addAttendence(Attendence attendence) {
		// TODO Auto-generated method stub
		return attendenceRepo.save(attendence);

	}

	@Override
	public Attendence saveAttendence(Attendence attendence) {
		// TODO Auto-generated method stub
		return attendenceRepo.save(attendence);
	}

	@Override
	public Attendence updateAttendence(Attendence attendence, Long id) {
		Attendence currentAttendence = attendenceRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Attendence not found with ID: " + id));

        currentAttendence.setDate(currentAttendence.getDate());
        currentAttendence.setStatus(currentAttendence.getStatus());

        return attendenceRepo.save(currentAttendence);
	}

	@Override
	public Attendence getAttendenceById(Long id) {
		return attendenceRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("Attendence not found bu Id :"+id));	}
	

	@Override
	public List<Attendence> getAllAttendence() {
		List< Attendence>attendence=this.attendenceRepo.findAll();
		List<Attendence>attendences=attendence.stream().map(n -> this.saveAttendence(n)).collect(Collectors.toList());
		return attendence;
	}

	@Override
	public Boolean deleteAttendenceById(Long id) {
		Optional<Attendence>attendence=attendenceRepo.findById(id);
		if(attendence.isPresent()) {
			attendenceRepo.deleteById(id);
			return true;
		}
		return false;
	}

}
