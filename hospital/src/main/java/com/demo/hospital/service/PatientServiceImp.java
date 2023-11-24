package com.demo.hospital.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.hospital.model.Patient;
import com.demo.hospital.repository.PatientRepository;

public class PatientServiceImp implements PatientService {
	@Autowired
	private PatientRepository patientRep;
	
	
	
	@Override
	public List<Patient> getAllPatient(){
		return patientRep.findAll();
	}
	
	@Override
	public void save(Patient patient) {
		
		patientRep.save(patient);
	}
	
	@Override
	public Patient UpdateById(Long id) {
		Optional<Patient> op = patientRep.findById(id);
		Patient patient = null;
		if(op.isPresent()) {
			patient=op.get();
		}
		else {
			throw new RuntimeException("patient not found");
		}
		return patient;
	}
		@Override
		public void deleteById(Long id) {
			patientRep.deleteById(id);
		
		}
		

}
