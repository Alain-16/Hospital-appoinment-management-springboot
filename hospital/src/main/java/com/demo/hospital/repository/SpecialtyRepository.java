package com.demo.hospital.repository;





import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.hospital.model.*;

public interface SpecialtyRepository extends JpaRepository<Specialization,Long> {
	
	 

}
