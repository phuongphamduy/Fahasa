package com.fahasa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fahasa.dao.SchoolToolDAO;
import com.fahasa.model.Book;
import com.fahasa.model.SchoolTool;
import com.fahasa.service.SchoolToolService;
@Service
public class SchoolToolServiceImpl implements SchoolToolService {
	
	@Autowired
	SchoolToolDAO stdao;

	@Override
	public List<SchoolTool> getAll() {
		return stdao.findAll();
	}

	 @Override
	public SchoolTool findById(Integer id) {
		return stdao.findById(id).get();
	}


}
