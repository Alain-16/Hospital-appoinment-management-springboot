package com.demo.hospital.service;


import java.time.LocalDate;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.hospital.model.Doctor;
import com.demo.hospital.model.Scheduler;
import com.demo.hospital.repository.DoctorRepository;
import com.demo.hospital.repository.ScheduleRepository;

@Service
public class DoctorServiceImp implements DoctorService {
	
	@Autowired
	private DoctorRepository doctorRep;
	
	@Autowired
	private ScheduleRepository scheduleRep;
	
	@Override
	public List<Doctor> getAllDoctor(){
		return doctorRep.findAll();
	}
	
	@Override
	public List<Scheduler> getAllScheduler(){
		return scheduleRep.findAll();
	}
	
	@Override
	public void save(Doctor doctor) {
		doctorRep.save(doctor);
	}
	
	@Override
	public Doctor UpdateById(Long id) {
		Optional<Doctor> op = doctorRep.findById(id);
		Doctor doctor = null;
		if(op.isPresent()) {
			doctor=op.get();
		}
		else {
			throw new RuntimeException("appointment not found");
		}
		return doctor;
	}
		@Override
		public void deleteById(Long id) {
			doctorRep.deleteById(id);
		
		}

		public void CreatingRepeatingEvents(String title, String description, LocalDate start, LocalDate end, LocalTime startTime, LocalTime endTime, List<Integer> repeatingDays) {
		    LocalDate currentDate = start;
		    int daysBetween = (int) ChronoUnit.DAYS.between(start, end);

		    while (daysBetween >= 0) {
		        for (Integer dayOfWeek : repeatingDays) {
		            if (currentDate.getDayOfWeek().getValue() == dayOfWeek) {
		                // Create a new event instance for this date
		                Scheduler scheduler = new Scheduler(title, startTime, endTime, currentDate, description);
		                
		                // Save the event to the database
		                scheduleRep.save(scheduler);
		            }
		        }
		        
		        // Move to the next day
		        currentDate = currentDate.plusDays(1);
		        daysBetween--;
		    }
		}

		  @Transactional
		    public void deleteSchedulesByTitle(String title) {
			  scheduleRep.deleteByTitle(title);
		    }
		  
		  @Override
		  public Optional<Scheduler> getSchedulerById(Long id) {
			 return  scheduleRep.findById(id);
			  
		  }
		  
		  @Override
		  public void saveSchedule(Scheduler scheduler) {
			  scheduleRep.save(scheduler);
		  }
		  
		  
		  

		  
		 
		
}
	
