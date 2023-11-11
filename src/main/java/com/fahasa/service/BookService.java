package com.fahasa.service;

import java.util.List;

import com.fahasa.model.Book;
import com.fahasa.model.Product;
import com.fasterxml.jackson.databind.JsonNode;

public interface BookService {

	List<Book> getAll();

	Book findById(Integer id);

	List<Book> findBooksByParentId(Integer id);

	List<Book> findBooksByParentId2(Integer id);

	List<Book> findBooksByParentId3(Integer id);

	Book create(JsonNode book);

	Book update(Book product);

	void delete(Integer id);

}
