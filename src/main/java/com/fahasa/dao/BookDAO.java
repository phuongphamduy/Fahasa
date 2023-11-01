package com.fahasa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fahasa.model.Book;

public interface BookDAO extends JpaRepository<Book, Integer> {
    List<Book> findByTitleContaining(String title);
}
