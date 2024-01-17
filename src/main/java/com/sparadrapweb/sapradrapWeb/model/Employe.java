package com.sparadrapweb.sapradrapWeb.model;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Employe {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idemploye;

    @OneToOne
	@JoinColumn(name="idpersonne") 
	public Personne personne;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date datenais;
}
