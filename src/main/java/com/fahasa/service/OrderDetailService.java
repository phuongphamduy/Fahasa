package com.fahasa.service;

import com.fahasa.model.OrderDetail;
import com.fasterxml.jackson.databind.JsonNode;

public interface OrderDetailService {

	OrderDetail updateQuantity(JsonNode data);

	void delete(Integer id);

}
