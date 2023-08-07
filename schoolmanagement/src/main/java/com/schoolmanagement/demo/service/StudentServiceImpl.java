package com.schoolmanagement.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.schoolmanagement.demo.entity.Student;
import com.schoolmanagement.demo.exception.UserNotFoundException;
import com.schoolmanagement.demo.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {
@Autowired
private StudentRepo studentRepo;
@Autowired
private ModelMapper modelMapper;

	@Override
	 public Student addStudent(Student student) {
		
        return studentRepo.save(student);
    }

@Override
	 public Student updateStudent(Student updatedStudent, Long id) {
	        Student existingStudent = studentRepo.findById(id)
	                .orElseThrow(() -> new IllegalArgumentException("Student not found with ID: " + id));

	        // Update fields
	        existingStudent.setName(updatedStudent.getName());
	        existingStudent.setAge(updatedStudent.getAge());
	        existingStudent.setAddress(updatedStudent.getAddress());
	        existingStudent.setGrade(updatedStudent.getGrade());
	        existingStudent.setRollNumber(updatedStudent.getRollNumber());
	        existingStudent.setPhoneNumber(updatedStudent.getPhoneNumber());

	        // Update other fields as needed
//	        Student updatedUser=this.studentRepo.save(existingStudent);
//	        Student user1=this.saveStudent(updatedUser);
	        return studentRepo.save(existingStudent);
	    }
	@Override
//	 public Student getStudentById(Long id) {
//        return studentRepo.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Student not found with ID: " + id));
//    }
	  public Student getStudentById(Long id) {
	        Optional<Student> userOptional = studentRepo.findById(id);
	        return userOptional.orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));
	    }
	 @Override
	    public List<Student> getAllStudents() {
	        List<Student>students=this.studentRepo.findAll();
	        List<Student>userDtos=students.stream().map(student -> this.saveStudent(student)).collect(Collectors.toList());
	        return students;
	    }
	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepo.save(student);
	}

	@Override
	public Boolean deleteStudentById(Long id) {
	//	Optional<Student>className=studentRepo.findById(id);
	//	if(className.isPresent()) {
			studentRepo.deleteById(id);
			return true;
	//	}
		//return false;
	}
@Override
	  public Page<Student> findPaginated(Integer pageNo, Integer pageSize) {
	        Pageable pageable = PageRequest.of(pageNo -1, pageSize);
	        return studentRepo.findAll(pageable);
	    }
	
}
