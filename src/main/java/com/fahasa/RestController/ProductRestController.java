package com.fahasa.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fahasa.model.Product;
import com.fahasa.service.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/product")
public class ProductRestController {
	
	@Autowired
	ProductService service;
	
	@GetMapping
	public List<Product> getAll() {
		return service.getAll();
	}
}
