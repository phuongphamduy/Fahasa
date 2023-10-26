package com.fahasa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fahasa.model.Voucher;

public interface VoucherDAO extends JpaRepository<Voucher, Integer> {

}
