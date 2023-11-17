package com.fahasa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fahasa.model.Order;

public interface OrderDAO extends JpaRepository<Order, Integer>{
	@Query("select o from Order o where o.statuss.id = 1 and o.user.id = ?1")
	Order getOrderInCartByUser(Integer id);
}
