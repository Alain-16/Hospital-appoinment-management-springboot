package com.demo.hospital.service;

import java.util.List;

import com.demo.hospital.model.Patient;

public interface PatientService {
	List<Patient>getAllPatient();
	void save(Patient patient);
	Patient UpdateById(Long id);
	//Patient FindPatientByEmail(String email);
	void deleteById(Long id);
	

}
