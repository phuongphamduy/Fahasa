package com.fahasa.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fahasa.model.Order;
import com.fahasa.service.OrderService;
import com.fasterxml.jackson.databind.JsonNode;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/order")
public class OrderRestController {
	
	@Autowired
	OrderService service;
	
	@GetMapping()
	public List<Order> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/cart/{id}")
	public Order getOrderInCart(@PathVariable("id") Integer id) {
		return service.getOrderInCart(id);
	}
	
	@GetMapping("ordersuccess/{id}")
	public List<Order> getOrderSuccess(@PathVariable("id") Integer id) {
		return service.getOrderSuccess(id);
	}
	
	@PostMapping("/create")
	public Order create(@RequestBody JsonNode order) {
		return service.create(order);
	}
	
	@PostMapping("/payment")
	public Order payment(@RequestBody JsonNode data) {
		return service.payment(data);
	}
	
	@PatchMapping("/payment/success/{id}")
	public void paymentSuccess(@PathVariable("id") Integer id) {
		service.paymentSuccess(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Integer id) {
		service.delete(id);
	}

}
