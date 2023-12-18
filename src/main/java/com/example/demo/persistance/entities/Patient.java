package com.example.demo.persistance.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Patient implements Serializable{

	  public Patient() {
		super();
	}
	public Patient(Long id, String nom, String email, List<Rendezvous> rendezvousList) {
		super();
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.rendezvousList = rendezvousList;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Rendezvous> getRendezvousList() {
		return rendezvousList;
	}
	public void setRendezvousList(List<Rendezvous> rendezvousList) {
		this.rendezvousList = rendezvousList;
	}
	@Id 
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  private String nom;
	  private String email;
	  @JsonIgnore
	  @OneToMany(mappedBy="patient",fetch=FetchType.LAZY)
	  private List<Rendezvous>rendezvousList;
	
}
