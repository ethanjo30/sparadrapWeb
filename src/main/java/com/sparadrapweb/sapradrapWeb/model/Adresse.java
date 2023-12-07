package com.sparadrapweb.sapradrapWeb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Adresse {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idadresse")
    private Integer id_Adresse;

	@Column(name="numadresse")
	private int num_Adresse;
	
	@Column(name="nomrueadresse")
	private String nom_Rue_Adresse;
	
	@Column(name="codepostaladresse")
	private int code_Postal_Adresse;
	
	@Column(name="villeadresse")
	private String ville_Adresse;
}
