package com.schoolmanagement.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolmanagement.demo.entity.Subject;

@Repository
public interface SubjectRepo extends JpaRepository<Subject,Long>{

}
