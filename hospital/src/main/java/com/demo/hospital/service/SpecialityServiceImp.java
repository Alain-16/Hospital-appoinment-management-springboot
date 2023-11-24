package com.demo.hospital.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.hospital.model.Specialization;
import com.demo.hospital.repository.SpecialtyRepository;

public class SpecialityServiceImp implements SpecialityService {
	@Autowired
	private SpecialtyRepository sepRep;
	
	@Override
	public List<Specialization> getAllSpeciality(){
		return sepRep.findAll();
	}
	
	@Override
	public void save(Specialization speciality) {
		sepRep.save(speciality);
	}
	
	@Override
	public Specialization UpdateById(Long id) {
		Optional<Specialization> op = sepRep.findById(id);
		Specialization speciality = null;
		if(op.isPresent()) {
			speciality=op.get();
		}
		else {
			throw new RuntimeException("speciality not found");
		}
		return speciality;
	}
		@Override
		public void deleteById(Long id) {
			sepRep.deleteById(id);
		
		}
		/*@Override
		public List<Specialization> findByDoctor(int id){
			return sepRep.findByDoctor(id);
		}*/
		
}
