package com.demo.hospital.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.demo.hospital.repository.*;
import com.demo.hospital.model.*;

@RestController
public class SchedulerController {
	
	@Autowired
	private ScheduleRepository schedulerRep;
	
	 	@RequestMapping(value="/allevents",method=RequestMethod.GET)
	    public List<SchedulerEventsDto> getAllSchedules(){
	    	List<Scheduler> schedulerList = schedulerRep.findAll();
	    	
	    	List<SchedulerEventsDto> schedulers = new ArrayList<>();
	    	for (Scheduler scheduler : schedulerList) {
	            SchedulerEventsDto event = new SchedulerEventsDto();
	            event.setId(String.valueOf(scheduler.getId()));
	            event.setTitle(scheduler.getTitle());
	            event.setStart(scheduler.getSchedulerDate().toString() + "T" + scheduler.getStart().toString());
	            event.setEnd(scheduler.getSchedulerDate().toString() + "T" + scheduler.getEnd().toString());
	            schedulers.add(event);
	    	}
	    	return schedulers;
	    }
	 	
	
	

}
