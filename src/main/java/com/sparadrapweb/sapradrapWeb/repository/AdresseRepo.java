package com.sparadrapweb.sapradrapWeb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sparadrapweb.sapradrapWeb.model.Adresse;

@Repository
public interface AdresseRepo extends CrudRepository<Adresse, Integer>{
    
}
