package com.example.demo.service.controller;

import java.util.List;

import org.apache.el.parser.ParseException; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
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
import com.example.demo.persistance.entities.Rendezvous;
import com.example.demo.service.interfaces.IRendezvous;


@Controller
@RequestMapping("/api/rendezvous")
public class RendezvousController {

	@Autowired
	IRendezvous rendezvousservice;
	
	@RequestMapping(method = RequestMethod.POST, consumes="application/json", produces = "application/json")
	Rendezvous save(@RequestBody Rendezvous rendezvous) {	
		  System.out.println("*******save ***********");
		  Rendezvous r=rendezvousservice.saveRendezvous(rendezvous);
        return r ;
    }
	
	// Mapping to display the list of rendezvous (rendezvous.html)
    @GetMapping("/list")
    public String showRendezvousList(Model model) {
        List<Rendezvous> rendezvouss = rendezvousservice.getListRendezvous();
         model.addAttribute("rendezvous", rendezvouss);
        return "Rendezvous"; // Return the Rendezvous.html view
    }

    // Mapping to display the form for adding a new patient (NewRendezvous.html)
    @GetMapping("/add")
    public String showAddRendezvousForm(Model model) {
        model.addAttribute("rendezvous", new Rendezvous());
        return "NewRendezvous"; // Return the NewRendezvous.html view with an empty Rendezvous object
    }

    // Mapping to handle the submission of the new patient form
    @PostMapping("/save")
    public String addRendezvous(@ModelAttribute("rendezvous") Rendezvous rendezvous) {
        rendezvousservice.saveRendezvous(rendezvous);
        return "redirect:/api/rendezvous/list"; // Redirect to the rendezvous list page after adding
    }

    // Mapping to display the form for updating a patient (UpdateMedecin.html)
    @GetMapping("/update/{id}")
    public String showUpdateRendezvousForm(@PathVariable("id") Long id, Model model) {
        Rendezvous rendezvous = rendezvousservice.getRendezvous(id);
        model.addAttribute("rendezvous", rendezvous);
        return "UpdateRendezvous"; // Return the UpdateRendezvous.html view with the Rendezvous data
    }

    // Mapping to handle the submission of the updated Rendezvous form
    @PostMapping("/updated")
    public String updateRendezvous( @ModelAttribute("rendezvous") Rendezvous updatedRendezvous) {
    	rendezvousservice.updateRendezvous(updatedRendezvous);
        return "redirect:/api/rendezvous/list"; // Redirect to the patient list page after updating
    }
	
	
	@GetMapping("/{id}")
	Rendezvous getRendezvousById(@PathVariable Long id) {
        return rendezvousservice.getRendezvous(id);
    }
	
	@GetMapping("/quantity")
    int getQuantityRendezvous() {
        return rendezvousservice.getQuantityOfRendezvous();
    }
	
	@GetMapping("/rendezvousByName/{rendezvousname}")
	Rendezvous getRendezvousByName(@PathVariable String name) {
        return rendezvousservice.findRendezvousByName(name);
    }
	
	@GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
		rendezvousservice.deleteRendezvous(id);
		return "redirect:/api/rendezvous/list";
    }
}
