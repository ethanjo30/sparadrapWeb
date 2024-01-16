package com.sparadrapweb.sapradrapWeb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Login {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idlogin")
	private int idlogin;

    @Column(name="nomlogin")
	private String nomlogin;

    @Column(name="mdplogin")
	private String mdplogin;

    @Column(name="rolelogin")
	private String rolelogin;
    
}
