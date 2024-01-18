package com.sparadrapweb.sapradrapWeb.model;

import java.sql.Date;

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
public class Ordonance {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idordo;

    @Column(name="dateordo")
    private Date date_Ordo;

    @OneToOne
	@JoinColumn(name="idpat") 
	public Patient patient;

    @OneToOne
	@JoinColumn(name="idmedecin") 
	public Medecin medecin;
}
