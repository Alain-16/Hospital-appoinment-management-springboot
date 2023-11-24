package com.demo.hospital.controller;


import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.hospital.service.*;

import com.demo.hospital.model.*;

@Controller
public class AdminController {
	
	@Autowired
	private AppointmentService appointmentService;
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private PatientService patientService;
	
	
	@RequestMapping("/admin")
	public String getAdmin(Model model) {
		List<Appointment> appointmentList = appointmentService.getAllAppointment();
		model.addAttribute("appointment",appointmentList);
		return "AdminPanel/admin";
	}
	@RequestMapping("/view_appointment")
	public String viewAppointment(Model model) {
		List<Appointment> appointmentList = appointmentService.getAllAppointment();
		model.addAttribute("appointment",appointmentList);
		return "AdminPanel/view_appointment";
	}
	
	@RequestMapping("view_doctor")
	public String ViewDoctor(Model model) {
		List<Doctor> doctorList = doctorService.getAllDoctor();
		model.addAttribute("doctor",doctorList);
		return "AdminPanel/view_doctors";
			
		}
	
	@RequestMapping("/view_schedules")
	public String viewSchedules(Model model) { 
		return "AdminPanel/view_doctors_schedules";
	}
	
	@RequestMapping("view_patient")
	public String ViewPatient(Model model) {
		List<Patient> patientList = patientService.getAllPatient();
		model.addAttribute("patient", patientList);
		return "AdminPanel/view_patient";
			
		}
	@RequestMapping("/appointmentUpdate")
	public String appointmentUpdate(@RequestParam("appID") Long id,Model model) {
		Appointment appointment = appointmentService.UpdateById(id);
		model.addAttribute("appointment", appointment);
		return "AdminPanel/appointmentForm";
	}
	@RequestMapping("/doctorUpdate")
	public String doctorUpdate(@RequestParam("docID") Long id,Model model) {
		Doctor doctor = doctorService.UpdateById(id);
		model.addAttribute("doctor",doctor);
		return "AdminPanel/appointmentForm";
	}
	@RequestMapping("/patientUpdate")
	public String patientUpdate(@RequestParam("patientID") Long id,Model model) {
		Patient patient = patientService.UpdateById(id);
		model.addAttribute("patient", patient);
		return "AdminPanel/patientForm";
	}
	@RequestMapping("/doctorDelete")
	public String doctorDelete(@RequestParam("docID") Long id,Model model) {
		doctorService.deleteById(id);
		return "redirect:/view_doctor";
		
	}
	@RequestMapping("/patientDelete")
	public String patientDelete(@RequestParam("patientID") Long id,Model model) {
		patientService.deleteById(id);
		return "redirect:/view_patient";	
	}
	
	@RequestMapping("/appointmentDelete")
	public String appointmentDelete(@RequestParam("appID") Long id,Model model) {
		appointmentService.deleteById(id);
		return "redirect:/admin";
		
	}
	
	@RequestMapping("/schedule_form")
    public String showCreateForm(Model model) {
		List<String> daysOfWeek = Arrays.asList("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday");
		//System.out.println("==="+daysOfWeek.size());
	    model.addAttribute("daysOfWeek", daysOfWeek);
        Scheduler scheduler = new Scheduler();
    	model.addAttribute("scheduler", scheduler);
    	
        return "AdminPanel/doctorScheduleForm";
    }
	
	
	
	@RequestMapping("/create")
	public String createEvent(Scheduler scheduler, Model model) {
	   doctorService.CreatingRepeatingEvents(scheduler.getTitle(),
			   scheduler.getDescription(),
			   scheduler.getStartDate(),
			   scheduler.getEndDate(),
			   scheduler.getStart(),
			   scheduler.getEnd(),
			   scheduler.getDaysOfWeek()
			 
	   		
			   );
	    model.addAttribute("scheduler",scheduler);
	    return "redirect:/view_schedules";
	}
	
	@RequestMapping("deleteSchedule/{title}")
	public String deleteSchedule(@PathVariable("title") String title) {
		doctorService.deleteSchedulesByTitle(title);
		return"redirect:/view_schedules";
	}
	
	@RequestMapping("/updateScheduleForm/{id}")
	public String updateScheduleForm(@PathVariable("id") Long id,Model model) {
		Scheduler scheduler = doctorService.getSchedulerById(id).orElseThrow(() -> new RuntimeException("Schedule not found"));
		model.addAttribute("scheduler", scheduler);
		return "AdminPanel/scheduleUpdateForm";
	}
	
	@RequestMapping("/saveUpdateSchedule")
	public String saveSchedule(@ModelAttribute Scheduler scheduler) {
		doctorService.saveSchedule(scheduler);
		return "redirect:/view_schedules";
	}
	
	    
		
}
