package com.schoolmanagement.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.schoolmanagement.demo.entity.Student;


@Repository
public interface StudentRepo extends JpaRepository<Student, Long>{

	@Query("Select s from Student s where s.rollNumber=:rollNumber")
	Student findByRollNumber(@Param("rollNumber") String rollNumber);
}
