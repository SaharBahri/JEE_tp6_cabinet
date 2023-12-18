package com.example.demo.service.impliments;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.persistance.dao.ConsultationRepository;
import com.example.demo.persistance.entities.Consultation;
import com.example.demo.service.interfaces.IConsultation;

@Service
public class ConsultationService implements IConsultation {

	@Autowired
	ConsultationRepository consultationrepository;
	
	@Override
	public Consultation saveConsultation(Consultation consultation) {
		// TODO Auto-generated method stub
		return consultationrepository.save(consultation);
	}

	@Override
	public Consultation updateConsultation(Consultation consultation) {
		// TODO Auto-generated method stub
		return consultationrepository.saveAndFlush(consultation);
	}

	@Override
	public boolean deleteConsultation(Long id) {
		// TODO Auto-generated method stub
		consultationrepository.deleteById(id);
		return true;
	}

	@Override
	public List<Consultation> getListConsultation() {
		// TODO Auto-generated method stub
		return  consultationrepository.findAll();
	}

	@Override
	public Consultation getConsultation(Long id) {
		// TODO Auto-generated method stub
		return  consultationrepository.findById(id).get();
	}

	@Override
	public int getQuantityOfConsultation() {
		// TODO Auto-generated method stub
		return  consultationrepository.getQuantityOfConsultation();
	}

	@Override
	public Consultation getConsultationByIdConsultation(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Consultation findConsultationById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
