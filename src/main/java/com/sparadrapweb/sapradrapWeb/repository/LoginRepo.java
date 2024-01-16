package com.sparadrapweb.sapradrapWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sparadrapweb.sapradrapWeb.model.Login;

@Repository
public interface LoginRepo extends JpaRepository<Login, Integer>{

    public Login findByNomlogin(String nom_Login);
    
}
