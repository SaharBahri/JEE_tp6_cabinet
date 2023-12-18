package com.example.demo.service.impliments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.persistance.dao.SpecialityRepository;
import com.example.demo.persistance.entities.Speciality;
import com.example.demo.service.interfaces.ISpeciality;

@Service
public class SpecialityService implements ISpeciality {

	@Autowired
	SpecialityRepository specialityrepository;
	
	@Override
	public Speciality saveSpeciality(Speciality speciality) {
		// TODO Auto-generated method stub
		return specialityrepository.save(speciality);
	}

	@Override
	public Speciality updateSpeciality(Speciality speciality) {
		// TODO Auto-generated method stub
		return specialityrepository.saveAndFlush(speciality);
	}

	@Override
	public boolean deleteSpeciality(Long id) {
		// TODO Auto-generated method stub
		specialityrepository.deleteById(id);
		return true;
	}

	@Override
	public List<Speciality> getListSpeciality() {
		// TODO Auto-generated method stub
		return  specialityrepository.findAll();
	}

	@Override
	public Speciality getSpeciality(Long id) {
		// TODO Auto-generated method stub
		return  specialityrepository.findById(id).get();
	}

	@Override
	public Speciality findSpecialityByName(String name) {
		// TODO Auto-generated method stub
		return  specialityrepository.findByName(name);
	}

	@Override
	public int getQuantityOfSpeciality() {
		// TODO Auto-generated method stub
		return  specialityrepository.getQuantityOfSpeciality();
	}

	@Override
	public Speciality getSpecialityByIdSpeciality(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
