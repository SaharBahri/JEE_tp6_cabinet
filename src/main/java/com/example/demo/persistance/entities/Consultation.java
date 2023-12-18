package com.example.demo.persistance.entities;

import java.time.*;
import java.util.Date;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Consultation implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String RecapCon;
    
    @OneToOne
    @JoinColumn(name="id_rendezvous")
    private Rendezvous rendezvous;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRecapCon() {
		return RecapCon;
	}

	public void setRecapCon(String recapCon) {
		RecapCon = recapCon;
	}

	public Rendezvous getRendezvous() {
		return rendezvous;
	}

	public void setRendezvous(Rendezvous rendezvous) {
		this.rendezvous = rendezvous;
	}

	public Consultation(Long id, Date date, String recapCon, Rendezvous rendezvous) {
		super();
		this.id = id;
		this.date = date;
		RecapCon = recapCon;
		this.rendezvous = rendezvous;
	}

	public Consultation() {
		// TODO Auto-generated constructor stub
	}

	public String getConsultationName() {
		// TODO Auto-generated method stub
		return null;
	}

}
