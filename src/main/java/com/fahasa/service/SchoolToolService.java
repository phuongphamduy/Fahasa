package com.fahasa.service;

import java.util.List;

import com.fahasa.model.Book;
import com.fahasa.model.SchoolTool;

public interface SchoolToolService {

	List<SchoolTool> getAll();

	SchoolTool findById(Integer id);

}
