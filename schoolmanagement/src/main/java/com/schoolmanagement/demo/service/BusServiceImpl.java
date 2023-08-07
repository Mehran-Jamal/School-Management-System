package com.schoolmanagement.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolmanagement.demo.entity.Bus;
import com.schoolmanagement.demo.entity.ClassName;
import com.schoolmanagement.demo.repository.BusRepo;

@Service
public class BusServiceImpl  implements BusService{

	@Autowired
	private BusRepo busRepo;
	@Override
	public Bus addBus(Bus bus) {
		// TODO Auto-generated method stub
		return busRepo.save(bus);
	}

	@Override
	public Bus saveBus(Bus bus) {
		
		return busRepo.save(bus);
	}

	@Override
	public Bus updateBus(Bus bus, Long id) {
		   Bus existingBus = busRepo.findById(id)
	                .orElseThrow(() -> new IllegalArgumentException("Bus not found with ID: " + id));

	        existingBus.setBusNumber(bus.getBusNumber());
	        existingBus.setCapacity(bus.getCapacity());
	        existingBus.setDriverName(bus.getDriverName());

	       
	        return busRepo.save(existingBus);
	}

	@Override
	public Bus getBusById(Long id) {
		
		return busRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("Bus not found bu Id :"+id));
	}

	@Override
	public List<Bus> getAllBusses() {
		List< Bus>bus=this.busRepo.findAll();
		List<Bus>bus2=bus.stream().map(n -> this.saveBus(n)).collect(Collectors.toList());
		return bus;
	}

	@Override
	public Boolean deleteBusById(Long id) {
		Optional<Bus>bus=busRepo.findById(id);
		if(bus.isPresent()) {
			busRepo.deleteById(id);
			return true;
		}
		return false;
	}

    
}
