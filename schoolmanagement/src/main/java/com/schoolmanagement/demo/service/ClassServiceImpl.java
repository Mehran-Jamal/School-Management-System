package com.schoolmanagement.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolmanagement.demo.entity.ClassName;
import com.schoolmanagement.demo.entity.Student;
import com.schoolmanagement.demo.repository.ClassRepo;

@Service
public class ClassServiceImpl implements ClassService{

	@Autowired
	private ClassRepo classRepo;
	@Override
	public ClassName addClassName(ClassName className) {
		
		return classRepo.save(className);
	}

	@Override
	public ClassName saveClass(ClassName className) {
		
		return classRepo.save(className);
	}

	@Override
	public ClassName updateclass(ClassName className, Long id) {
		   ClassName existingClass = classRepo.findById(id)
	                .orElseThrow(() -> new IllegalArgumentException("Class not found with ID: " + id));

	        existingClass.setClassName(className.getClassName());
	       
	        return classRepo.save(existingClass);
	}

	@Override
	public ClassName getClassById(Long id) {
		
		return classRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("Class not found with ID: " + id));
	}

	@Override
	public List<ClassName> getAllClassNames() {
		List< ClassName>classNames=this.classRepo.findAll();
		List<ClassName>classNames2=classNames.stream().map(n -> this.saveClass(n)).collect(Collectors.toList());
		return classNames;
	}

	@Override
	public Boolean deleteClassNameById(Long id) {
		Optional<ClassName>className=classRepo.findById(id);
		if(className.isPresent()) {
			classRepo.deleteById(id);
			return true;
		}
		return false;
	}

}
