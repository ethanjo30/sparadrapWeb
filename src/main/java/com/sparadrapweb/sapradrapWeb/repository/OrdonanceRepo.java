package com.sparadrapweb.sapradrapWeb.repository;

import org.springframework.data.repository.CrudRepository;

import com.sparadrapweb.sapradrapWeb.model.Ordonance;

@repository
public interface OrdonanceRepo extends CrudRepository<Ordonance, Integer>{
    
}
