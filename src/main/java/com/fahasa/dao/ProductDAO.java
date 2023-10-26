package com.fahasa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fahasa.model.Product;

public interface ProductDAO extends JpaRepository<Product, Integer> {

}
