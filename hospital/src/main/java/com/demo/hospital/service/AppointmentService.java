package com.demo.hospital.service;

import java.util.*;
import com.demo.hospital.model.*;

public interface AppointmentService {
	List<Appointment>getAllAppointment();
	void save(Appointment appointment);
	Appointment UpdateById(Long id);
	void deleteById(Long id);
	

}
