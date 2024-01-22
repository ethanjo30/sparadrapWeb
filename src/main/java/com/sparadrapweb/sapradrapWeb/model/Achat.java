package com.sparadrapweb.sapradrapWeb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Achat {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idachat;

    @OneToOne
    @JoinColumn(name="idordo")
    public Ordonance ordonnances;

    @OneToOne
    @JoinColumn(name="idpat")
    public Patient patient;
}
