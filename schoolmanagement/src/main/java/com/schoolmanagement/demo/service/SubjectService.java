package com.schoolmanagement.demo.service;

import java.util.List;

import com.schoolmanagement.demo.entity.Subject;



public interface SubjectService {
	Subject addSubject(Subject subject);
	 Subject saveSubject(Subject subject);
    Subject updateSubject(Subject subject,Long id);
    Subject getSubjectById(Long id);
    List<Subject>getAllSubjects();
    Boolean deleteSubjectById(Long id);

}
