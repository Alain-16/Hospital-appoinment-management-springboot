package com.demo.hospital.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.hospital.model.Scheduler;

public interface ScheduleRepository extends JpaRepository<Scheduler, Long> {
	void deleteByTitle(String title);
	
}
