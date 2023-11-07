package com.fahasa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fahasa.dao.VoucherDAO;
import com.fahasa.model.Voucher;
import com.fahasa.service.VoucherService;

@Service
public class VoucherServiceImpl implements VoucherService {
	
	@Autowired
	VoucherDAO vdao;

	@Override
	public List<Voucher> getVoucherStillValid() {
		return vdao.getVoucherStillValid(true);
	}

}
