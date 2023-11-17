package com.fahasa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fahasa.dao.OrderDAO;
import com.fahasa.model.Order;
import com.fahasa.model.OrderDetail;
import com.fahasa.service.OrderService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderDAO odao;

	@Override
	public Order create(JsonNode order) {
		ObjectMapper mapper = new ObjectMapper();
		Order o = mapper.convertValue(order, Order.class);
		Order orderFromDB = odao.getOrderInCartByUser(o.getUser().getId());
		if(orderFromDB.getId() > 0) {
			List<OrderDetail> list = o.getOrderdetails();
			for(int i = 0; i < list.size();i++) {
				list.get(i).setOrder(orderFromDB);
			}
			orderFromDB.setOrderdetails(list);
			orderFromDB.setTotalamount(o.getTotalamount() + orderFromDB.getTotalamount());
			return odao.save(orderFromDB);
		}
		return odao.save(o);
		
	}

	@Override
	public List<Order> getAll() {
		return odao.findAll();
	}

	@Override
	public Order getOrderInCart(Integer id) {
		Order o = odao.getOrderInCartByUser(id);
		return o;
	}

}
