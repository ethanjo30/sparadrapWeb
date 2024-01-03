package com.sparadrapweb.sapradrapWeb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
	@ManyToOne
	@JoinColumn(name = "idadresse")
	public Adresse adresse;
	
	@Column(name="telpersonne")
	private int tel_Personne;

	@Column(name="emailpersonne")
	private String email_Personne;

	
}
