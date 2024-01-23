package com.sparadrapweb.sapradrapWeb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Contient {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcontient;
    
    @ManyToOne
    @JoinColumn(name="idordo")
    public Ordonance ordonance;

    @ManyToOne
    @JoinColumn(name="idmed")
    public Medicament medicament;
}
