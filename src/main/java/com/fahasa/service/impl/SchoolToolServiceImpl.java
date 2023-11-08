package com.fahasa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fahasa.dao.SchoolToolDAO;
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

	@Override
	public List<SchoolTool> findToolsByParentId2(Integer id) {
		return stdao.findToolsByParentId2(id);
	}

	@Override
	public List<SchoolTool> findToolsByParentId3(Integer id) {
		return stdao.findToolsByParentId3(id);
	}

}
