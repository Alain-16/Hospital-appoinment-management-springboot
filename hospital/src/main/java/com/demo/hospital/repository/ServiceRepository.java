package com.demo.hospital.repository;

import org.springframework.stereotype.Repository;
import com.demo.hospital.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ServiceRepository extends JpaRepository<HospitalServiceEntity,Long> {
	

}
