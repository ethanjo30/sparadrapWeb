package com.sparadrapweb.sapradrapWeb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Patient {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idpat")
    private Integer id_pat;

	@Column(name="idpersonne")
	private String id_Personne;
	
	@Column(name="idmut")
	private String id_Mut;
	
	@Column(name="datenaispat")
	private int date_Nais_Pat;
	
	@Column(name="numsecupat")
	private int num_Secu_Pat;
}
