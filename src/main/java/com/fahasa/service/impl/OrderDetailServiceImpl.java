package com.fahasa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fahasa.dao.OrderDetailDAO;
import com.fahasa.model.OrderDetail;
import com.fahasa.service.OrderDetailService;
import com.fasterxml.jackson.databind.JsonNode;
@Service
public class OrderDetailServiceImpl implements OrderDetailService {
	
	@Autowired
	OrderDetailDAO ddao;

	@Override
	public OrderDetail updateQuantity(JsonNode data) {
		OrderDetail od =  ddao.findById(data.get("id").asInt()).get();
		if(data.get("type").asText().equals("desc")) {
			if(od.getQuantity() > 1) {
				od.setQuantity(od.getQuantity()- 1);
			}
		}else if(data.get("type").asText().equals("asc")) {
			od.setQuantity(od.getQuantity() + 1);
		}
		return ddao.save(od);
	}

	@Override
	public void delete(Integer id) {
		ddao.deleteById(id);
	}

	@Override
	public List<Object[]> getProductInSuccessOrder(Integer id) {
		List<Object[]> list = ddao.getBookInSuccessOrder(id);
		List<Object[]> list1 = ddao.getSchoolToolInSuccessOrder(id);
		list.addAll(list1);
		return list;
	}

	@Override
	public List<OrderDetail> getAll() {
		return ddao.findAll();
	}
	
	

}
