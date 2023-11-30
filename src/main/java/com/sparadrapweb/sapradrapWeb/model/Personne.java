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
    private Integer idPersonne;

	@Column(name="nompersonne")
	private String nomPersonne;
	
	@Column(name="prenompersonne")
	private String prenomPersonne;
	
	@Column(name="idadresse")
	private int idAdresse;
	
	@Column(name="telpersonne")
	private int telPersonne;

	@Column(name="emailpersonne")
	private String emailPersonne;
}
