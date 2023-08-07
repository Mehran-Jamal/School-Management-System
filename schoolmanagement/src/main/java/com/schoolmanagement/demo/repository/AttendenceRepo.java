package com.schoolmanagement.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.schoolmanagement.demo.entity.Attendence;
import com.schoolmanagement.demo.entity.Holiday;
import com.schoolmanagement.demo.entity.Student;

@Repository
public interface AttendenceRepo extends JpaRepository<Attendence, Long>{

	
}
