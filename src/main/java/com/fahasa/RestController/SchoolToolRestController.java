package com.fahasa.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fahasa.model.SchoolTool;
import com.fahasa.service.SchoolToolService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/schooltool")
public class SchoolToolRestController {
	
	@Autowired
	SchoolToolService service;
	
	@GetMapping
	public List<SchoolTool> getAll() {
		return service.getAll();
	}
	
}
