package com.fahasa.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fahasa.service.AddressService;

@CrossOrigin
@RestController
@RequestMapping("/rest/address")
public class AddressRestController {
	@Autowired
	AddressService service;
}
