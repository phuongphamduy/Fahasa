package com.fahasa.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fahasa.model.OrderDetail;
import com.fahasa.service.OrderDetailService;
import com.fasterxml.jackson.databind.JsonNode;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orderdetail")
public class OrderDetailRestController {
	@Autowired
	OrderDetailService service;
	
	@PatchMapping("/updateQuantity")
	public OrderDetail updateQuantity(@RequestBody JsonNode data) {
		return service.updateQuantity(data);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Integer id) {
		service.delete(id);
	}
}
