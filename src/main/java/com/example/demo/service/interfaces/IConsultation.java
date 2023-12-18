package com.example.demo.service.interfaces;

import java.util.List;

import com.example.demo.persistance.entities.Consultation;

public interface IConsultation {

		Consultation saveConsultation(Consultation consultation);
		Consultation updateConsultation(Consultation consultation);
	     boolean deleteConsultation(Long id);
	     List<Consultation> getListConsultation();
	     Consultation getConsultation(Long id);
	     Consultation findConsultationById(Long id);
	     int getQuantityOfConsultation();
	     Consultation getConsultationByIdConsultation(Long id);
	
	
}
