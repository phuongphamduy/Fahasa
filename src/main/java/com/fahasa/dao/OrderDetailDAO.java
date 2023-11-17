package com.fahasa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fahasa.model.OrderDetail;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Integer> {
	@Query("select d from OrderDetail d where d.order.id = ?1")
	List<OrderDetail> getOrderDetailByOrderId(Integer id);
}
