package com.sparadrapweb.sapradrapWeb.model;

import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Patient {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idpat;
	
	@Column(name="idmut")
	private int id_Mut;
	
	@Column(name="datenaispat")
	private int date_Nais_Pat;
	
	@Column(name="numsecupat")
	private BigInteger num_Secu_Pat;

	@OneToOne
	@JoinColumn(name="idpersonne") 
	public Personne personne ;

}

