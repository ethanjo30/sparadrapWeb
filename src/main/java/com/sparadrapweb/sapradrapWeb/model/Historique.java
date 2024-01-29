package com.sparadrapweb.sapradrapWeb.model;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
public class Historique {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idhisto")
	private int idhisto;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="dathisto")
	private Date datehisto;

    @Column(name="nommed")
	private String nommed;

    @Column(name="patient")
	private String nompat;

    @ManyToOne
	@JoinColumn(name="idachat") 
	public Achat achat ;
}