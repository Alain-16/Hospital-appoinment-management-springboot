package com.demo.hospital.service;

import java.util.List;


import com.demo.hospital.model.Specialization;

public interface SpecialityService {
	List<Specialization>getAllSpeciality();
	void save(Specialization speciality);
	Specialization UpdateById(Long id);
	void deleteById(Long id);
	

}
