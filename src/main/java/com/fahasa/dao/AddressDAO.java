package com.fahasa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fahasa.model.Address;

public interface AddressDAO extends JpaRepository<Address, Integer> {

}
