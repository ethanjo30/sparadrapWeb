package com.sparadrapweb.sapradrapWeb.model;

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
    private Integer idPersonne;

	private String nomPersonne;
	
	private String prenomPersonne;
	
	private int idAdresse;
	
	private int telPersonne;

	private String emailPersonne;
}
