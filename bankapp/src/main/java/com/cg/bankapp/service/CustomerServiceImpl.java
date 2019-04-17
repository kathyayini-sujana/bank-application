package com.cg.bankapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bankapp.dao.CustomerDao;
import com.cg.bankapp.model.Customer;

@Service("customerService")

public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Override
	public List<Customer> findAll() {
		List<Customer> customerlist = customerDao.findAll();
		return customerlist;
	}

	@Override
	public void save(Customer customer) {
		customerDao.save(customer);
	}

	@Override
	public Customer findById(Integer id) {
		Customer customer=customerDao.findById(id).get();
		return customer;
	}

	@Override
	public Customer findByIdAndPassword(Integer id, String password) {
		Customer customer=null;
		try {
			customer=customerDao.findByIdAndPassword(id,password);
		}
		catch(Exception e) {
			customer=null;
		}
		return customer ;
	}

}
