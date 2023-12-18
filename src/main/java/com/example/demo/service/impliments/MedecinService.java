package com.example.demo.service.impliments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.persistance.dao.MedecinRepository;
import com.example.demo.persistance.entities.Medecin;
import com.example.demo.service.interfaces.IMedecin;

@Service
public class MedecinService implements IMedecin {

	@Autowired
	MedecinRepository medecinrepository;
	
	@Override
	public Medecin saveMedecin(Medecin medecin) {
		// TODO Auto-generated method stub
		return medecinrepository.save(medecin);
	}

	@Override
	public Medecin updateMedecin(Medecin medecin) {
		// TODO Auto-generated method stub
		return medecinrepository.saveAndFlush(medecin);
	}

	@Override
	public boolean deleteMedecin(Long id) {
		// TODO Auto-generated method stub
		 medecinrepository.deleteById(id);
		return true;
	}

	@Override
	public List<Medecin> getListMedecin() {
		// TODO Auto-generated method stub
		return  medecinrepository.findAll();
	}

	@Override
	public Medecin getMedecin(Long id) {
		// TODO Auto-generated method stub
		return  medecinrepository.findById(id).get();
	}

	@Override
	public Medecin findMedecinByName(String name) {
		// TODO Auto-generated method stub
		return  medecinrepository.findByName(name);
	}

	@Override
	public int getQuantityOfMedecin() {
		// TODO Auto-generated method stub
		return  medecinrepository.getQuantityOfMedecin();
	}

	@Override
	public Medecin getMedecinByIdMedecin(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
