package com.schoolmanagement.demo.service;

import java.util.List;

import com.schoolmanagement.demo.entity.Fee;
import com.schoolmanagement.demo.entity.Teachers;

public interface TeacherService {
	 Teachers addTeacher(Teachers teachers);
	 Teachers saveTeacher(Teachers teachers);
     Teachers updateTeacher(Teachers teachers,Long id);
     Teachers getTeacherById(Long id);
     List<Teachers>getAllTeachers();
     Boolean deleteTeacherById(Long id);

}
