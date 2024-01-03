package com.sparadrapweb.sapradrapWeb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sparadrapweb.sapradrapWeb.model.Medicament;


@Repository
public interface MedicamentRepo extends CrudRepository<Medicament, Integer> {
    
}
