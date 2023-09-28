package com.fahasa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fahasa.model.Book;

public interface BookDAO extends JpaRepository<Book, Integer> {

}
