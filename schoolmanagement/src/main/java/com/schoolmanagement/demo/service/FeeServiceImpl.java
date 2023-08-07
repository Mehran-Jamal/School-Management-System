package com.schoolmanagement.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolmanagement.demo.entity.Bus;
import com.schoolmanagement.demo.entity.Fee;
import com.schoolmanagement.demo.repository.FeeRepo;

@Service
public class FeeServiceImpl implements FeeService{
 @Autowired
 private FeeRepo feeRepo;
	@Override
	public Fee addFee(Fee fee) {
		// TODO Auto-generated method stub
		return feeRepo.save(fee);
	}
	@Override
	public Fee saveFee(Fee fee) {
		// TODO Auto-generated method stub
		return feeRepo.save(fee);
	}

	@Override
	public Fee updateFee(Fee fee, Long id) {
		// TODO Auto-generated method stub
		 Fee currentFee = feeRepo.findById(id)
	                .orElseThrow(() -> new IllegalArgumentException("Fee not found with ID: " + id));

	        currentFee.setAmount(fee.getAmount());
	        currentFee.setPaymentDate(fee.getPaymentDate());

	       
	        return feeRepo.save(currentFee);
	}

	@Override
	public Fee getFeeById(Long id) {
		// TODO Auto-generated method stub
		return feeRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("Bus not found bu Id :"+id));	}

	@Override
	public List<Fee> getAllFee() {
		// TODO Auto-generated method stub
		List< Fee>fee=this.feeRepo.findAll();
		List<Fee>fee2=fee.stream().map(n -> this.saveFee(n)).collect(Collectors.toList());
		return fee;
	}

	@Override
	public Boolean deleteFeeById(Long id) {
		Optional<Fee>fee=feeRepo.findById(id);
		if(fee.isPresent()) {
			feeRepo.deleteById(id);
			return true;
		}
		return false;
	}
	}




