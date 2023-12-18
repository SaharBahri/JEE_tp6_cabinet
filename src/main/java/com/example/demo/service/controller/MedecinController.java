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

import com.example.demo.persistance.entities.Medecin;
import com.example.demo.persistance.entities.Patient;
import com.example.demo.service.interfaces.IMedecin;

@Controller
@RequestMapping("/api/medecin")
public class MedecinController {

	@Autowired
	IMedecin medecinservice;
	
	@RequestMapping(method = RequestMethod.POST, consumes="application/json", produces = "application/json")
    Medecin save(@RequestBody Medecin medecin) {	
		  System.out.println("*******save ***********");
		  Medecin m=medecinservice.saveMedecin(medecin);
		  System.out.println("*******"+m.getEmail());
        return m ;
    }
	
	// Mapping to display the list of Medecin (Medecin.html)
    @GetMapping("/list")
    public String showMedecinList(Model model) {
        List<Medecin> medecins = medecinservice.getListMedecin();
         model.addAttribute("medecin", medecins);
        return "Medecin"; // Return the Medecin.html view
    }

    // Mapping to display the form for adding a new patient (NewMedecin.html)
    @GetMapping("/add")
    public String showAddMedecinForm(Model model) {
        model.addAttribute("medecin", new Medecin());
        return "NewMedecin"; // Return the NewMedecin.html view with an empty Medecin object
    }

    // Mapping to handle the submission of the new patient form
    @PostMapping("/save")
    public String addMedecin(@ModelAttribute("medecin") Medecin medecin) {
        medecinservice.saveMedecin(medecin);
        return "redirect:/api/medecin/list"; // Redirect to the Medecin list page after adding
    }

    // Mapping to display the form for updating a patient (UpdateMedecin.html)
    @GetMapping("/update/{id}")
    public String showUpdateMedecinForm(@PathVariable("id") Long id, Model model) {
        Medecin medecin = medecinservice.getMedecin(id);
        model.addAttribute("medecin", medecin);
        return "UpdateMedecin"; // Return the UpdateMedecin.html view with the Medecin data
    }

    // Mapping to handle the submission of the updated Medecin form
    @PostMapping("/updated")
    public String update( @ModelAttribute("medecin") Medecin updatedMedecin) {
        medecinservice.updateMedecin(updatedMedecin);
        return "redirect:/api/medecin/list"; // Redirect to the patient list page after updating
    }

	
	@GetMapping("/{id}")
    Medecin getMedecinById(@PathVariable Long id) {
        return medecinservice.getMedecin(id);
    }
	
	@GetMapping("/quantity")
    int getQuantityMedecin() {
        return medecinservice.getQuantityOfMedecin();
    }
	
	@GetMapping("/medecinByName/{nom}")
    Medecin getMedecinByName(@PathVariable String name) {
        return medecinservice.findMedecinByName(name);
    }
	
	@GetMapping("/delete/{id}")
    public String deleteMedecin(@PathVariable Long id) {
        medecinservice.deleteMedecin(id);
        return "redirect:/api/medecin/list";
    }
	
	
	
}
