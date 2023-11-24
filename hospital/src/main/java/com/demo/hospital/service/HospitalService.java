package com.demo.hospital.service;

import java.util.List;



import com.demo.hospital.model.HospitalServiceEntity;


public interface HospitalService {
	
	List<HospitalServiceEntity> getAllService();
	void save(HospitalServiceEntity hospitalServiceEntity);
	HospitalServiceEntity UpdateById(Long id);
	void deleteById(Long id);

}
