package com.fahasa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fahasa.dao.CategoryDAO;
import com.fahasa.model.Category;
import com.fahasa.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDAO cdao;
	
	@Override
	public List<Category> getAll() {
		return cdao.findAll();
	}

}
