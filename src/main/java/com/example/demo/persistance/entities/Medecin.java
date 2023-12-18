package com.example.demo.persistance.entities;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Medecin implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Getter
    //@Setter
    private Long id;
    private String name;
    private String email;
    @OneToMany(mappedBy = "medecin")
    private List<Rendezvous> Listrdv;
    
    @OneToOne
    @JoinColumn(name="id_speciality")
    private Speciality speciality;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Rendezvous> getListrdv() {
		return Listrdv;
	}

	public void setListrdv(List<Rendezvous> listrdv) {
		Listrdv = listrdv;
	}

	public Speciality getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}

	public Medecin(Long id, String name, String email, List<Rendezvous> listrdv, Speciality speciality) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		Listrdv = listrdv;
		this.speciality = speciality;
	}

	public Medecin() {
		// TODO Auto-generated constructor stub
	}
  
    
}