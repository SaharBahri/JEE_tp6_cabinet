package com.example.demo.service.interfaces;

import java.util.List;

import com.example.demo.persistance.entities.Speciality;

public interface ISpeciality {

		Speciality saveSpeciality(Speciality speciality);
		Speciality updateSpeciality(Speciality speciality);
	     boolean deleteSpeciality(Long id);
	     List<Speciality> getListSpeciality();
	     Speciality getSpeciality(Long id);
	     Speciality findSpecialityByName(String name);
	     int getQuantityOfSpeciality();
	     Speciality getSpecialityByIdSpeciality(Long id);
	
	
}
