package com.demo.hospital.model;


import jakarta.persistence.*;

@Entity
@Table(name="patient")
public class Patient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="patient_id")
	private long id;
	
	@Column(name="patient_name")
	private String patientName;
	
	@Column(name="patient_email")
	private String patientEmail;
	
	@Column(name="patient_phone")
	private int patientPhone;
	
	@Column(name="patient_password")
	private String patientPassword;
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientEmail() {
		return patientEmail;
	}

	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}

	public int getPatientPhone() {
		return patientPhone;
	}

	public void setPatientPhone(int patientPhone) {
		this.patientPhone = patientPhone;
	}

	public String getPatientPassword() {
		return patientPassword;
	}

	public void setPatientPassword(String patientPassword) {
		this.patientPassword = patientPassword;
	}
}
