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
import com.example.demo.persistance.entities.Speciality;
import com.example.demo.service.interfaces.ISpeciality;


@Controller
@RequestMapping("/api/speciality")
public class SpecialityController {

	@Autowired
	ISpeciality specialityservice;
	
	@RequestMapping(method = RequestMethod.POST, consumes="application/json", produces = "application/json")
	Speciality save(@RequestBody Speciality speciality) {	
		  System.out.println("*******save ***********");
		  Speciality s=specialityservice.saveSpeciality(speciality);
		  System.out.println("*******"+s.getName());
        return s ;
    }
	
	// Mapping to display the list of speciality (speciality.html)
    @GetMapping("/list")
    public String showSpecialityList(Model model) {
        List<Speciality> specialitys = specialityservice.getListSpeciality();
         model.addAttribute("speciality", specialitys);
        return "Speciality"; // Return the Speciality.html view
    }

    // Mapping to display the form for adding a new patient (NewSpeciality.html)
    @GetMapping("/add")
    public String showAddSpecialityForm(Model model) {
        model.addAttribute("speciality", new Speciality());
        return "NewSpeciality"; // Return the NewSpeciality.html view with an empty Speciality object
    }

    // Mapping to handle the submission of the new patient form
    @PostMapping("/save")
    public String addSpeciality(@ModelAttribute("speciality") Speciality speciality) {
        specialityservice.saveSpeciality(speciality);
        return "redirect:/api/speciality/list"; // Redirect to the Speciality list page after adding
    }

    // Mapping to display the form for updating a patient (UpdateSpeciality.html)
    @GetMapping("/update/{id}")
    public String showUpdateSpecialityForm(@PathVariable("id") Long id, Model model) {
        Speciality speciality = specialityservice.getSpeciality(id);
        model.addAttribute("speciality", speciality);
        return "UpdateSpeciality"; // Return the UpdateSpeciality.html view with the Speciality data
    }

    // Mapping to handle the submission of the updated Speciality form
    @PostMapping("/updated")
    public String updateSpeciality( @ModelAttribute("speciality") Speciality updatedSpeciality) {
        specialityservice.updateSpeciality(updatedSpeciality);
        return "redirect:/api/speciality/list"; // Redirect to the patient list page after updating
    }
	
	@GetMapping("/{id}")
	Speciality getSpecialityById(@PathVariable Long id) {
        return specialityservice.getSpeciality(id);
    }
	
	@GetMapping("/quantity")
    int getQuantitySpeciality() {
        return specialityservice.getQuantityOfSpeciality();
    }
	
	@GetMapping("/specialityByName/{specialityname}")
	Speciality getSpecialityByName(@PathVariable String name) {
        return specialityservice.findSpecialityByName(name);
    }
	
	@GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
		specialityservice.deleteSpeciality(id);
		return "redirect:/api/speciality/list";
    }
}
