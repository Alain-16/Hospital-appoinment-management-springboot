package com.demo.hospital.service;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import com.demo.hospital.model.Doctor;
import com.demo.hospital.model.Scheduler;

public interface DoctorService {
	List<Doctor>getAllDoctor();
	List<Scheduler>getAllScheduler();
	void save(Doctor doctor);
	Doctor UpdateById(Long id);
	Optional<Scheduler> getSchedulerById(Long id);
	void saveSchedule(Scheduler scheduler);
	void deleteById(Long id);
	void CreatingRepeatingEvents(String title,String description, LocalDate start,LocalDate end,LocalTime startTime,LocalTime endTime, List<Integer> repeatingDays);
	public void deleteSchedulesByTitle(String title) ;
	

}
