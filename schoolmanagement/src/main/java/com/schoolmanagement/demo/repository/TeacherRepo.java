package com.schoolmanagement.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolmanagement.demo.entity.Teachers;

@Repository
public interface TeacherRepo extends JpaRepository<Teachers, Long>{

}
