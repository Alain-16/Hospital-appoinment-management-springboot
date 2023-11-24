package com.demo.hospital.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name="specialty")
public class Specialization {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="speciality_id")
	private long id;
	
	@Column(name="speciality_name")
	private String specialty_name;
	
	@ManyToMany(mappedBy="specialities")
	private Set<Doctor> doctors = new HashSet<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSpecialty_name() {
		return specialty_name;
	}

	public void setSpecialty_name(String specialty_name) {
		this.specialty_name = specialty_name;
	}

	public Set<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(Set<Doctor> doctors) {
		this.doctors = doctors;
	}
	
	
}
