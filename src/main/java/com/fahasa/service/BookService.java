package com.fahasa.service;

import java.util.List;

import com.fahasa.model.Book;

public interface BookService {

	List<Book> getAll();

	Book findById(Integer id);

	List<Book> findBooksByParentId(Integer id);

	List<Book> findBooksByParentId2(Integer id);

	List<Book> findBooksByParentId3(Integer id);

}
