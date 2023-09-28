package com.fahasa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fahasa.model.Authority;

public interface AuthorityDAO extends JpaRepository<Authority, Integer> {

}
