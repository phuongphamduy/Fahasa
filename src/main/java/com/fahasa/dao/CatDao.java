package com.fahasa.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.fahasa.model.Cat;

public interface CatDao extends JpaRepository<Cat, Integer> {

}

