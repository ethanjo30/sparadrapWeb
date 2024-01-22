package com.sparadrapweb.sapradrapWeb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sparadrapweb.sapradrapWeb.model.Achat;

@Repository
public interface AchatRepo extends CrudRepository<Achat, Integer>  {
    
}