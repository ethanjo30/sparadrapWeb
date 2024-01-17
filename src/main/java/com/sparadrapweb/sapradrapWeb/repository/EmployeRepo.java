package com.sparadrapweb.sapradrapWeb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sparadrapweb.sapradrapWeb.model.Employe;

@Repository
public interface EmployeRepo extends CrudRepository<Employe, Integer> {
    
}
