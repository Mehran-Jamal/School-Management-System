package com.schoolmanagement.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolmanagement.demo.entity.Bus;

@Repository
public interface BusRepo  extends JpaRepository<Bus, Long> {

}
