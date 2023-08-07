package com.schoolmanagement.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.schoolmanagement.demo.entity.ClassName;
import com.schoolmanagement.demo.entity.Student;
@Repository
public interface ClassRepo extends JpaRepository<ClassName, Long> {
	@Query("Select s from ClassName s where s.className=:className")
	Student findByClassName(@Param("className") String className);
}
