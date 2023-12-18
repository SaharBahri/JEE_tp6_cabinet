package com.example.demo.persistance.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Speciality implements Serializable {
	    @Id 
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    @OneToMany (fetch = FetchType.EAGER)
	    private List<Medecin> medecin;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public List<Medecin> getMedecin() {
			return medecin;
		}
		public void setMedecin(List<Medecin> medecin) {
			this.medecin = medecin;
		}
		public Speciality(Long id, String name, List<Medecin> medecin) {
			super();
			this.id = id;
			this.name = name;
			this.medecin = medecin;
		}
		public Speciality() {
			// TODO Auto-generated constructor stub
		}

	

}
