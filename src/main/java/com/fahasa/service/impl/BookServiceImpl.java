package com.fahasa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fahasa.dao.BookDAO;
import com.fahasa.model.Book;
import com.fahasa.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDAO bdao;

	@Override
	public List<Book> getAll() {
		return bdao.findAll();
	}

	@Override
	public Book findById(Integer id) {
		return bdao.findById(id).get();
	}

	@Override
	public List<Book> findBooksByParentId(Integer id) {
		return bdao.findBooksByParentId(id);
	}

	@Override
	public List<Book> findBooksByParentId2(Integer id) {
		return bdao.findBooksByParentId2(id);
	}

	@Override
	public List<Book> findBooksByParentId3(Integer id) {
		return bdao.findBooksByParentId3(id);
	}

	// @Override
	// public List<Book> findBooksByParentId(Integer id) {
	// return bdao.findBooksByParentId(id);
	// }

	// @Override
	// public List<Book> findByName(String title) {
	// return bdao.findByTitle(title);
	// }

}
