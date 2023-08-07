package com.schoolmanagement.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolmanagement.demo.entity.Subject;
import com.schoolmanagement.demo.entity.Teachers;
import com.schoolmanagement.demo.repository.SubjectRepo;

@Service
public class SubjectServiceImpl implements SubjectService{

	@Autowired
	private SubjectRepo subjectRepo;
	@Override
	public Subject addSubject(Subject subject) {
		// TODO Auto-generated method stub
		return subjectRepo.save(subject);
	}

	@Override
	public Subject saveSubject(Subject subject) {
		// TODO Auto-generated method stub
		return subjectRepo.save(subject);
	}

	@Override
	public Subject updateSubject(Subject subject, Long id) {
		// TODO Auto-generated method stub
		 Subject currentSubject = subjectRepo.findById(id)
	                .orElseThrow(() -> new IllegalArgumentException("Subject not found with ID: " + id));

	        currentSubject.setName(subject.getName());
	       
	        return subjectRepo.save(currentSubject);
	}

	@Override
	public Subject getSubjectById(Long id) {
		// TODO Auto-generated method stub
		return subjectRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("Subject not found bu Id :"+id));
	}

	@Override
	public List<Subject> getAllSubjects() {
		List< Subject>subjects=this.subjectRepo.findAll();
		List<Subject>subjects2=subjects.stream().map(n -> this.saveSubject(n)).collect(Collectors.toList());
		return subjects;
	}

	@Override
	public Boolean deleteSubjectById(Long id) {
		Optional<Subject>subject=subjectRepo.findById(id);
		if(subject.isPresent()) {
			subjectRepo.deleteById(id);
			return true;
		}
		return false;
	}

}
