package com.fahasa.service;

import java.util.List;

import com.fahasa.model.Book;

public interface BookService {

	List<Book> getAll();

	Book findById(Integer id);

	// List<Book> findByName(String title);
}
