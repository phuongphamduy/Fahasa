package com.fahasa.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fahasa.model.Voucher;
import com.fahasa.service.VoucherService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/voucher")
public class VoucherRestController {
	
	@Autowired
	VoucherService service;
	
	@GetMapping
	public List<Voucher> getVouchersStillValid() {
		return service.getVoucherStillValid();
	}
}
