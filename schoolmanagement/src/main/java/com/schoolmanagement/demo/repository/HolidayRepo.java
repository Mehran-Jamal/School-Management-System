package com.schoolmanagement.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.schoolmanagement.demo.entity.Holiday;

@Repository
public interface HolidayRepo extends JpaRepository<Holiday, Long> {
	@Query("Select h from Holiday h where h.date=:date")
	Holiday findByDate(@Param("date") String date);
}
