package com.example.demo.persistance.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.persistance.entities.Consultation;
public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
	
	Optional<Consultation> findById(Long id);
	

    @Query(value = "select count(*) from Consultation",nativeQuery = true)
    int getQuantityOfConsultation();
    @Query(value = "select * from Consultation where id= :id",nativeQuery = true)
    Consultation getConsultationByIdConsultation(@Param("id") Long id);

}
