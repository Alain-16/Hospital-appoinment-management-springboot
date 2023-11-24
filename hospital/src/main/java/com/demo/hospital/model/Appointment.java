package com.demo.hospital.model;

import java.time.LocalDate;
import java.time.LocalTime;


import jakarta.persistence.*;;

@Entity
@Table(name="appointment")
public class Appointment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="appointment_id")
	private long id;
		
	@Column(name="patient_name")
	private String patient_Name;
	
	@Column(name="patient_contact")
	private String patient_number;
	
	@Column(name="patient_email")
	private String patientEmail;
	
	@Column(name="appointment_date")
	private LocalDate appointmentDate;
	
	@Column(name="start_time")
	private LocalTime startTime;
	
	@Column(name="type")
	private String type;
	
	@Column(name="status")
	private String appointment_status;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPatient_Name() {
		return patient_Name;
	}

	public void setPatient_Name(String patient_Name) {
		this.patient_Name = patient_Name;
	}

	public String getPatient_number() {
		return patient_number;
	}

	public void setPatient_number(String patient_number) {
		this.patient_number = patient_number;
	}
	

	public String getPatientEmail() {
		return patientEmail;
	}

	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public String getAppointment_status() {
		return appointment_status;
	}

	public void setAppointment_status(String appointment_status) {
		this.appointment_status = appointment_status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	


	
	
	

}
