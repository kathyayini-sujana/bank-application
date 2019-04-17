package com.cg.bankapp.service;

import java.util.List;

import com.cg.bankapp.model.Transaction;

public interface TransactionService {
	public void save(Transaction transaction);

	public List<Transaction> findByCustomerId(Integer id);

}
