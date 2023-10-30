package com.fahasa.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fahasa.model.Book;
import com.fahasa.model.Product;
import com.fahasa.service.BookService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/book")
public class BookRestController {
	
	@Autowired
	BookService service;
	
	@GetMapping()
	public List<Book> main() {
		return service.getAll();
	}

	@GetMapping("{id}")
	public Book getProduct(@PathVariable("id") Integer id) {
		return service.findById(id);
	}
}
