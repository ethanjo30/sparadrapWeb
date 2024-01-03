package com.sparadrapweb.sapradrapWeb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sparadrapweb.sapradrapWeb.model.Mutuelle;

@Repository
public interface MutuelleRepo extends CrudRepository<Mutuelle, Integer>{

    
}