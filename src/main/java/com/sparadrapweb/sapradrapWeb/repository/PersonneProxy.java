package com.sparadrapweb.sapradrapWeb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sparadrapweb.sapradrapWeb.model.Personne;

@Repository
public interface PersonneProxy extends CrudRepository<Personne, Integer> {
} 