package com.sparadrapweb.sapradrapWeb.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Medicament {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idmed")
    private Integer id_Med;

	@Column(name="nommed")
	private String nom_Med;
	
	@Column(name="catemed")
	private String cate_Med;
	
	@Column(name = "prixmed")
	private int prix_Med;
	
	@Column(name="dateservicemed")
	private Date date_Service_Med;

	@Column(name="quantitemed")
	private String quantite_Med;
}
