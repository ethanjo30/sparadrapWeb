package com.sparadrapweb.sapradrapWeb.model;

import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Medecin {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idmedecin")
    private Integer id_Medecin;

    @OneToOne
	@JoinColumn(name="idpersonne")
	public Personne personne;
    
	@Column(name="numagrement")
	private BigInteger num_Agrement;
	
	@Column(name="spemedecin")
	private String spe_Medecin;
}
