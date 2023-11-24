package com.demo.hospital.model;

import java.time.LocalDate;
import java.util.*;



import jakarta.persistence.*;

@Entity()
@Table(name="Doctor")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Dr_id")
	private long id;
	
	@Column(name="fist_name")
	private String doctor_first_name;
	
	@Column(name="sur_name")
	private String doctor_sur_name;
	
	@Column(name="gender")
	private String doctor_gender;
	
	@Column(name="date_of_birth")
	private LocalDate doctor_date_birth;
	
	@Column(name="contact_number")
	private String doctor_number;
	
	@Column(name="email")
	private String doctor_email;
	
	@ManyToMany
	 @JoinTable(
	  name="doctor_specialty",
	  joinColumns=@JoinColumn(name="doctor_id"),
	  inverseJoinColumns=@JoinColumn(name="speciality_id")
	 )
	private Set<Specialization> specialities = new HashSet<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDoctor_first_name() {
		return doctor_first_name;
	}

	public void setDoctor_first_name(String doctor_first_name) {
		this.doctor_first_name = doctor_first_name;
	}

	public String getDoctor_sur_name() {
		return doctor_sur_name;
	}

	public void setDoctor_sur_name(String doctor_sur_name) {
		this.doctor_sur_name = doctor_sur_name;
	}

	public String getDoctor_gender() {
		return doctor_gender;
	}

	public void setDoctor_gender(String doctor_gender) {
		this.doctor_gender = doctor_gender;
	}

	public LocalDate getDoctor_date_birth() {
		return doctor_date_birth;
	}

	public void setDoctor_date_birth(LocalDate doctor_date_birth) {
		this.doctor_date_birth = doctor_date_birth;
	}

	public String getDoctor_number() {
		return doctor_number;
	}

	public void setDoctor_number(String doctor_number) {
		this.doctor_number = doctor_number;
	}

	public String getDoctor_email() {
		return doctor_email;
	}

	public void setDoctor_email(String doctor_email) {
		this.doctor_email = doctor_email;
	}

	public Set<Specialization> getSpecialities() {
		return specialities;
	}

	public void setSpecialities(Set<Specialization> specialities) {
		this.specialities = specialities;
	}



}
