package com.sparadrapweb.sapradrapWeb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Personne {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idpersonne")
    private Integer id_Personne;

	@Column(name="nompersonne")
	private String nom_Personne;
	
	@Column(name="prenompersonne")
	private String prenom_Personne;
	
	@Column(name="idadresse")
	private int id_Adresse;
	
	@Column(name="telpersonne")
	private int tel_Personne;

	@Column(name="emailpersonne")
	private String email_Personne;
}
