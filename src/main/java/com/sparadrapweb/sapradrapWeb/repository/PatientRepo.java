package com.sparadrapweb.sapradrapWeb.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sparadrapweb.sapradrapWeb.model.Patient;

@Repository
public interface PatientRepo extends CrudRepository<Patient, Integer> {
    
}
