package com.cg.bankapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bankapp.model.Transaction;

public interface TransactionDao extends JpaRepository<Transaction, Integer> {
	public List<Transaction> findByCustomerId(Integer id);

}
