package com.cg.bankapp.service;

import java.util.List;

import com.cg.bankapp.model.Customer;

public interface CustomerService {

	public List<Customer> findAll();

	public void save(Customer customer);

	public Customer findById(Integer id);

	public Customer findByIdAndPassword(Integer id, String password);
}
