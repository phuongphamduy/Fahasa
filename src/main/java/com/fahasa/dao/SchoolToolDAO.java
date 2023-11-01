package com.fahasa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fahasa.model.SchoolTool;

public interface SchoolToolDAO extends JpaRepository<SchoolTool, Integer> {
    List<SchoolTool> findByTitleContaining(String title);
}
