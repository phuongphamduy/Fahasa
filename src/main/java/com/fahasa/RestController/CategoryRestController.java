package com.fahasa.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fahasa.model.Category;
import com.fahasa.service.CategoryService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/category")
public class CategoryRestController {
	
	@Autowired
	CategoryService service;
	
	@GetMapping()
	public List<Category> getAll() {
		return service.getAll();
	}
}
