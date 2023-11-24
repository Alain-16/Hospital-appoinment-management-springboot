package com.demo.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.demo.hospital.model.HospitalServiceEntity;
import com.demo.hospital.repository.ServiceRepository;
import java.util.List;
import java.util.Optional;

@Service
public class HospitalServiceImp implements HospitalService {
	
	@Autowired
	private ServiceRepository serviceRepository;
	
	@Override
	public List<HospitalServiceEntity> getAllService(){
		return serviceRepository.findAll();
	}
	
	@Override
	public void save(HospitalServiceEntity serviceEntity) {
		serviceRepository.save(serviceEntity);
	}
	
	@Override
	public HospitalServiceEntity UpdateById(Long id) {
		Optional<HospitalServiceEntity> op = serviceRepository.findById(id);
		HospitalServiceEntity serviceEntity = null;
		if(op.isPresent()) {
			serviceEntity=op.get();
		}
		else {
			throw new RuntimeException("service not found");
		}
		return serviceEntity;
	}
		@Override
		public void deleteById(Long id) {
			serviceRepository.deleteById(id);
		
		}
	
	
	
	

}
