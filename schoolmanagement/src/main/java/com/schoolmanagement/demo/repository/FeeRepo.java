package com.schoolmanagement.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolmanagement.demo.entity.Fee;

@Repository
public interface FeeRepo extends JpaRepository<Fee, Long>{

}
