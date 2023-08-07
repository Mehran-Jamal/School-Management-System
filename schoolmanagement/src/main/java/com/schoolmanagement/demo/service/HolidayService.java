package com.schoolmanagement.demo.service;

import java.util.List;

import com.schoolmanagement.demo.entity.Holiday;

public interface HolidayService {
	

	 Holiday addHoliday(Holiday holiday);
	 Holiday saveHoliday(Holiday holiday);
//     Holiday updateHoliday(Holiday holiday,Long id);
     Holiday getHolidayById(Long id);
     List<Holiday>getAllHoliday();
     Boolean deleteHolidayById(Long id);
}
