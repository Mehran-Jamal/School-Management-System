package com.schoolmanagement.demo.service;

import java.util.List;

import com.schoolmanagement.demo.entity.Bus;
import com.schoolmanagement.demo.entity.Fee;

public interface FeeService {
	 Fee addFee(Fee fee);
	 Fee saveFee(Fee fee);
     Fee updateFee(Fee fee,Long id);
     Fee getFeeById(Long id);
     List<Fee>getAllFee();
     Boolean deleteFeeById(Long id);
	
}
