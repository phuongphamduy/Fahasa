package com.fahasa.service;


import java.util.List;

import com.fahasa.model.Order;
import com.fasterxml.jackson.databind.JsonNode;

public interface OrderService {

	Order create(JsonNode order);

	List<Order> getAll();

	Order getOrderInCart(Integer id);

	Order payment(JsonNode data);

}
