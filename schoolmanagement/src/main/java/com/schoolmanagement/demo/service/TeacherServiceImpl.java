package com.schoolmanagement.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolmanagement.demo.entity.Fee;
import com.schoolmanagement.demo.entity.Teachers;
import com.schoolmanagement.demo.repository.TeacherRepo;

@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TeacherRepo teacherRepo;
	@Override
	public Teachers addTeacher(Teachers teachers) {
		// TODO Auto-generated method stub
		return teacherRepo.save(teachers);
	}

	@Override
	public Teachers saveTeacher(Teachers teachers) {
		// TODO Auto-generated method stub
		return teacherRepo.save(teachers);
	}

	@Override
	public Teachers updateTeacher(Teachers teachers, Long id) {
		 Teachers currentTeacher = teacherRepo.findById(id)
	                .orElseThrow(() -> new IllegalArgumentException("Teacher not found with ID: " + id));

	        currentTeacher.setName(teachers.getName());
	        currentTeacher.setAge(teachers.getAge());
	        currentTeacher.setQualification(teachers.getQualification());
	        currentTeacher.setNumber(teachers.getNumber());
	        
	       
	        return teacherRepo.save(currentTeacher);
	}

	@Override
	public Teachers getTeacherById(Long id) {
		// TODO Auto-generated method stub
		return teacherRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("Teacher not found bu Id :"+id));
	}

	@Override
	public List<Teachers> getAllTeachers() {
		// TODO Auto-generated method stub
		List< Teachers>teachers=this.teacherRepo.findAll();
		List<Teachers>teachers2=teachers.stream().map(n -> this.saveTeacher(n)).collect(Collectors.toList());
		return teachers;
	}

	@Override
	public Boolean deleteTeacherById(Long id) {
		Optional<Teachers>teachers=teacherRepo.findById(id);
		if(teachers.isPresent()) {
			teacherRepo.deleteById(id);
			return true;
		}
		return false;
	}

}
