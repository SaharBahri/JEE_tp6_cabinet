package com.example.demo.service.controller;


import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.persistance.entities.Patient;
import com.example.demo.service.interfaces.IPatient;

@Controller
@RequestMapping("/api/patient")
public class PatientController {
	
	@Autowired
	IPatient patientservice;

    // Mapping to display the list of patients (Patient.html)
    @GetMapping("/list")
    public String showPatientList(Model model) {
        List<Patient> patients = patientservice.getListPatient();
         model.addAttribute("patients", patients);
        return "Patient"; // Return the Patient.html view
    }

    // Mapping to display the form for adding a new patient (NewPatient.html)
    @GetMapping("/add")
    public String showAddPatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "NewPatient"; // Return the NewPatient.html view with an empty patient object
    }

    // Mapping to handle the submission of the new patient form
    @PostMapping("/save")
    public String addPatient(@ModelAttribute("patient") Patient patient) {
        patientservice.savePatient(patient);
        return "redirect:/api/patient/list"; // Redirect to the patient list page after adding
    }

    // Mapping to display the form for updating a patient (UpdatePatient.html)
    @GetMapping("/update/{id}")
    public String showUpdatePatientForm(@PathVariable("id") Long id, Model model) {
        Patient patient = patientservice.getPatient(id);
        model.addAttribute("patient", patient);
        return "UpdatePatient"; // Return the UpdatePatient.html view with the patient data
    }

    // Mapping to handle the submission of the updated patient form
    @PostMapping("/updated")
    public String Update( @ModelAttribute("patient") Patient updatedPatient) {
        patientservice.updatePatient(updatedPatient);
        return "redirect:/api/patient/list"; // Redirect to the patient list page after updating
    }
    @GetMapping("/deleted/{id}")
	public String deletePatient(@PathVariable Long id) {
		patientservice.deletePatient(id);
		return "redirect:/api/patient/list";
	}

	@GetMapping("/quantity")
	int getQuantityPatient() {
		return patientservice.getQuantityOfPatient();
	}

	@GetMapping("/patientByName/{name}")
	Patient getPatientByName(@PathVariable String name) {
		return patientservice.findPatientByName(name);
	}
	

}
