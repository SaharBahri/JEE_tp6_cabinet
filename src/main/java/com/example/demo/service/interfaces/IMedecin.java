package com.example.demo.service.interfaces;

import java.util.List;

import com.example.demo.persistance.entities.Medecin;

public interface IMedecin {

		Medecin saveMedecin(Medecin medecin);
		Medecin updateMedecin(Medecin medecin);
	     boolean deleteMedecin(Long id);
	     List<Medecin> getListMedecin();
	     Medecin getMedecin(Long id);
	     Medecin findMedecinByName(String nom);
	     int getQuantityOfMedecin();
	     Medecin getMedecinByIdMedecin(Long id);
	
	
}
