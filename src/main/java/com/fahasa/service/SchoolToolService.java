package com.fahasa.service;

import java.util.List;

import com.fahasa.model.SchoolTool;

public interface SchoolToolService {

	List<SchoolTool> getAll();

<<<<<<< Updated upstream
=======
	SchoolTool findById(Integer id);

	List<SchoolTool> findToolsByParentId2(Integer id);

	List<SchoolTool> findToolsByParentId3(Integer id);

>>>>>>> Stashed changes
}
