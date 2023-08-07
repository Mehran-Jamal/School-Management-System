package com.schoolmanagement.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolmanagement.demo.entity.Attendence;
import com.schoolmanagement.demo.entity.Holiday;
import com.schoolmanagement.demo.repository.HolidayRepo;

@Service
public class HolidayServiceImpl implements HolidayService{
	@Autowired
	private HolidayRepo holidayRepo;
	

	@Override
	public Holiday addHoliday(Holiday holiday) {
		// TODO Auto-generated method stub
		return holidayRepo.save(null);
	}
	

	@Override
	public Holiday saveHoliday(Holiday holiday) {
		// TODO Auto-generated method stub
		return holidayRepo.save(holiday);
	}

	@Override
	public Holiday getHolidayById(Long id) {
		// TODO Auto-generated method stub
		return holidayRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("Holiday not found bu Id :"+id));	}
	
	@Override
	public List<Holiday> getAllHoliday() {
		List< Holiday>holiday=this.holidayRepo.findAll();
		List<Holiday>attendences=holiday.stream().map(n -> this.saveHoliday(n)).collect(Collectors.toList());
		return holiday;
	}

	@Override
	public Boolean deleteHolidayById(Long id) {
		Optional<Holiday>holiday=holidayRepo.findById(id);
		if(holiday.isPresent()) {
			holidayRepo.deleteById(id);
			return true;
		}
		return false;
	}
	
}
