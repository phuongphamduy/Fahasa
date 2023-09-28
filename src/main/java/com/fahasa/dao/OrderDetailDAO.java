package com.fahasa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fahasa.model.OrderDetail;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Integer> {

}
