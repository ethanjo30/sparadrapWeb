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
public class Mutuelle {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idmut")
    private Integer id_mut;

	@Column(name="nommut")
	private String nom_Mut;
	
	@ManyToOne
	@JoinColumn(name = "idadresse")
	public Adresse adresse;
	
	@Column(name="telmut")
	private int tel_Mut;

	@Column(name="emailmut")
	private String email_Mut;

    @Column(name="depmut")
	private String dep_Mut;

    @Column(name="tauxrembmut")
	private String taux_Remb_Mut;
}
