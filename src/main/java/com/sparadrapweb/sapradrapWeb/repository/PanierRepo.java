package com.sparadrapweb.sapradrapWeb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sparadrapweb.sapradrapWeb.model.Panier;

@Repository
public interface PanierRepo extends CrudRepository<Panier, Integer> {
   
}
