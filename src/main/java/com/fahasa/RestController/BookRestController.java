package com.fahasa.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fahasa.dao.BookDAO;
import com.fahasa.model.Book;
import com.fahasa.service.BookService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/book")
public class BookRestController {

	@Autowired
	BookService service;
	@Autowired
	private BookDAO BookDAO;

	@GetMapping()
	public List<Book> main() {
		return service.getAll();
	}

	@GetMapping("{id}")
	public Book getProduct(@PathVariable("id") Integer id) {
		return service.findById(id);
	}

	@GetMapping("/search")
	public List<Book> searchByName(@RequestParam String q) {
		return BookDAO.findByTitleContaining(q);
	}

	@GetMapping("/cate/{id}")
	public List<Book> findBooksByCate(@PathVariable("id") Integer id) {
		return BookDAO.findBooksByParentId(id);
	}

	@GetMapping("/cate2/{id}")
	public List<Book> findBooksByCate2(@PathVariable("id") Integer id) {
		return BookDAO.findBooksByParentId2(id);
	}

	@GetMapping("/cate3/{id}")
	public List<Book> findBooksByCate3(@PathVariable("id") Integer id) {
		return BookDAO.findBooksByParentId3(id);
	}
}
