package com.cg.bankapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bankapp.model.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

	public Customer findByIdAndPassword(Integer id, String password);

}
