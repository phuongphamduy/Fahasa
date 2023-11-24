package com.fahasa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fahasa.dao.ReviewDAO;
import com.fahasa.model.Review;
import com.fahasa.service.ReviewService;
import com.fasterxml.jackson.databind.JsonNode;
@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	ReviewDAO dao;

	@Override
	public Review send(JsonNode data) {
		System.out.println(data);
		return null;
	}

}
