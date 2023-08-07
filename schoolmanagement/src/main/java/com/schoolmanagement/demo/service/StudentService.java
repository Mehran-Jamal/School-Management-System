package com.schoolmanagement.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.schoolmanagement.demo.entity.Student;

public interface StudentService {
	
    Student addStudent(Student student);
    Student saveStudent(Student student);
    Student updateStudent(Student student,Long id);
    Student getStudentById(Long id);
    List<Student> getAllStudents();
    Boolean deleteStudentById(Long id);
    Page<Student> findPaginated(Integer pageNo,Integer pageSize);
}
