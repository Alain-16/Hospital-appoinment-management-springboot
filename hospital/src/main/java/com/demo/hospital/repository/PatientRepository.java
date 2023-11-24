package com.demo.hospital.repository;



//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.hospital.model.*;

public interface PatientRepository extends JpaRepository<Patient,Long> {

	


}
