package com.sparadrapweb.sapradrapWeb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sparadrapweb.sapradrapWeb.model.Medecin;

@Repository
public interface MedecinRepo extends CrudRepository<Medecin, Integer>{
  
} 
