package com.fahasa.service;

import java.util.List;

import com.fahasa.model.Voucher;

public interface VoucherService {

	List<Voucher> getVoucherStillValid();

}
