package com.demo.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.hospital.repository.DoctorRepository;
import com.demo.hospital.repository.PatientRepository;
import com.demo.hospital.service.AppointmentService;
import com.demo.hospital.service.DoctorService;
import com.demo.hospital.service.HospitalService;
import com.demo.hospital.service.PatientService;
import com.demo.hospital.service.SpecialityService;



import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.*;
import com.demo.hospital.model.*;

@Controller
public class HomeController {
	
	@Autowired
	public AppointmentService appointmentService;
	
	@Autowired
	public DoctorService doctorService;
	
	@Autowired
	public SpecialityService specialityService;
	
	@Autowired
	public PatientService patientService;
	
	@Autowired
	public PatientRepository patientRepository;
	
	@Autowired
	public DoctorRepository doctorRepository;
	
	@Autowired
	public HospitalService hospitalService;
	
	@RequestMapping("/home")
	public String getHome(Model model) {
		Appointment appointment = new Appointment();
		List<Doctor> doctors = doctorService.getAllDoctor();
		List<HospitalServiceEntity> speciality = hospitalService.getAllService();
		model.addAttribute("doctors", doctors);
		model.addAttribute("speciality", speciality);
		model.addAttribute("appointment", appointment);
		
		return "webpage/index";
	}
	
	@RequestMapping("/appointment")
	public String getAppointment(Model model) {
		Appointment appointment = new Appointment();
		model.addAttribute("appointment", appointment);
		return "webpage/appointment";
	}
	
	@RequestMapping("/about")
	public String getAbout(Model model) {
		//model.addAttribute("aboutpage", model);
		return "webpage/about";
	}
	
	@RequestMapping("/service")
	public String getService(Model model) {
		//model.addAttribute("servicepage", model);
		return "webpage/service";
	}
	
	@RequestMapping("/team")
	public String getTeam(Model model) {
		//model.addAttribute("teampage", model);
		return "webpage/team";
	}
	
	@RequestMapping("/search")
	public String getSearch(Model model) {
		//model.addAttribute("searchpage", model);
		return "webpage/search";
	}
	
	@RequestMapping("/blog")
	public String getBlog(Model model) {
		//model.addAttribute("blogpage", model);
		return "webpage/blog";
	}
	
	@RequestMapping("/price")
	public String getDetail(Model model) {
		//model.addAttribute("detailpage", model);
		return "webpage/price";
	}
	
	@RequestMapping("/contact")
	public String getContact(Model model) {
		//model.addAttribute("contactpage", model);
		return "webpage/contact";
	}
	
	@RequestMapping("/appointmentRegister")
	public String saveAppointment(@ModelAttribute("appointment") Appointment appointment,RedirectAttributes redMessage) {
		appointmentService.save(appointment);
		redMessage.addFlashAttribute("Appointment successfully submitted", redMessage);
		return "redirect:/home";
	}
	@RequestMapping("/register/patient")
	public String patientRegistration(Model model,Principal principal) {
		/*String username = principal.getName();
		Patient patient = patientRepository.findByPatientEmail(username).orElseThrow(() -> new UsernameNotFoundException("Patient not found"));*/
		Patient patient = new Patient();
		model.addAttribute("patient", patient);
		return "webpage/patientRegistration";
	}
	@RequestMapping("/patientSave")
	public String patientSave(Model model,Patient patient) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(patient.getPatientPassword());
		patient.setPatientPassword(encodedPassword);
		patientService.save(patient);
		return "redirect:/home";	
	}
	
	

}
