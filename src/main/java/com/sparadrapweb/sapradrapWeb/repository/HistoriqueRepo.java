package com.sparadrapweb.sapradrapWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sparadrapweb.sapradrapWeb.model.Historique;

@Repository
public interface HistoriqueRepo extends JpaRepository<Historique, Integer>{
  
} 
