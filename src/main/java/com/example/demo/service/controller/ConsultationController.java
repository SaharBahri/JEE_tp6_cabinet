package com.example.demo.service.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.apache.el.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.persistance.entities.Consultation;
import com.example.demo.persistance.entities.Patient;
import com.example.demo.service.interfaces.IConsultation;

@SuppressWarnings("unused")
@Controller
@RequestMapping("/api/consultation")
public class ConsultationController {

	@Autowired
	IConsultation consultationservice;

	@PostMapping(consumes = "application/json", produces = "application/json")
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	Consultation save(@RequestBody Consultation consultation) {
		System.out.println("*******save ***********");
		Consultation c = consultationservice.saveConsultation(consultation);
		System.out.println("*******" + c.getConsultationName());
		return c;
	}

	// Mapping to display the list of consultation (consultation.html)
	@GetMapping("/list")
	public String showConsultationList(Model model) {
		List<Consultation> Consultations = consultationservice.getListConsultation();
		model.addAttribute("consultation", Consultations);
		return "Consultation"; // Return the Consultation.html view
	}

	// Mapping to display the form for adding a new patient (NewConsultation.html)
	@GetMapping("/add")
	public String showAddConsultationForm(Model model) {
		model.addAttribute("consultation", new Consultation());
		return "NewConsultation"; // Return the NewConsultation.html view with an empty Consultation object
	}

	// Mapping to handle the submission of the new cons form
	@PostMapping("/save")
	public String addConsultation(@ModelAttribute("consultation") Consultation consultation) {
		consultationservice.saveConsultation(consultation);
		return "redirect:/api/consultations/list"; // Redirect to the consultation list page after adding
	}

	// Mapping to display the form for updating a patient (Updateconsultation.html)
	@GetMapping("/update/{id}")
	public String showUpdateConsultationForm(@PathVariable("id") Long id, Model model) {
		Consultation consultation = consultationservice.getConsultation(id);
		model.addAttribute("consultation", consultation);
		return "UpdateConsultation"; // Return the Updateconsultation.html view with the consultation data
	}

	// Mapping to handle the submission of the updated consultation form
	@PostMapping("/updated")
		 public String updateConsultation( @ModelAttribute("consultation") Consultation updatedConsultation) {
			 consultationservice.updateConsultation(updatedConsultation);
		return "redirect:/api/consultation/list"; // Redirect to the patient list page after updating
	}

	@GetMapping("/{id}")
	Consultation getConsultationById(@PathVariable Long id) {
		return consultationservice.getConsultation(id);
	}

	@GetMapping("/quantity")
	int getQuantityConsultation() {
		return consultationservice.getQuantityOfConsultation();
	}

	/**
	 * @GetMapping("/consultationByName/{consultationname}") Consultation
	 * getConsultationById1(@PathVariable Long id) { return
	 * consultationservice.findConsultationById(id); }
	 */

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		consultationservice.deleteConsultation(id);
		return "redirect:/api/consultations/list"; 
	}
}
