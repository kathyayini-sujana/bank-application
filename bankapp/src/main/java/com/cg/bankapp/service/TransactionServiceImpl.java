package com.cg.bankapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bankapp.dao.TransactionDao;
import com.cg.bankapp.model.Transaction;

@Service("transactionService")
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionDao transactionDao;

	@Override
	public void save(Transaction transaction) {
		transactionDao.save(transaction);
	}

	@Override
	public List<Transaction> findByCustomerId(Integer id) {
		List<Transaction> list = transactionDao.findByCustomerId(id);
		return list;
	}

}
