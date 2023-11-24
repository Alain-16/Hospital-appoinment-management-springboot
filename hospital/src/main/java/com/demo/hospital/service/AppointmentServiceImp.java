package com.demo.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.hospital.model.Appointment;
import com.demo.hospital.repository.AppointmentRepository;
import java.util.*;

@Service
public class AppointmentServiceImp implements AppointmentService {
	
	@Autowired
	private AppointmentRepository appRep;
	
	@Override
	public List<Appointment> getAllAppointment(){
		return appRep.findAll();
	}
	
	@Override
	public void save(Appointment appointment) {
		appRep.save(appointment);
	}
	
	@Override
	public Appointment UpdateById(Long id) {
		Optional<Appointment> op = appRep.findById(id);
		Appointment appointment = null;
		if(op.isPresent()) {
			appointment=op.get();
		}
		else {
			throw new RuntimeException("appointment not found");
		}
		return appointment;
	}
		@Override
		public void deleteById(Long id) {
			appRep.deleteById(id);
		}
		
	}


