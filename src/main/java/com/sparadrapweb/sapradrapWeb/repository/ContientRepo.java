package com.sparadrapweb.sapradrapWeb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sparadrapweb.sapradrapWeb.model.Contient;

@Repository
public interface ContientRepo extends CrudRepository<Contient, Integer>{
   
}
