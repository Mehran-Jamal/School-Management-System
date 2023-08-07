package com.schoolmanagement.demo.service;

import java.util.List;

import com.schoolmanagement.demo.entity.Attendence;


public interface AttendenceService {

	 Attendence addAttendence(Attendence attendence);
	 Attendence saveAttendence(Attendence attendence);
     Attendence updateAttendence(Attendence attendence,Long id);
     Attendence getAttendenceById(Long id);
     List<Attendence>getAllAttendence();
     Boolean deleteAttendenceById(Long id);
}
