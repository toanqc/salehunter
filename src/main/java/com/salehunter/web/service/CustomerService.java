package com.salehunter.web.service;

import java.util.List;

import javax.ejb.Local;

import com.salehunter.web.entity.Customer;

/**
 * 
 * @author qct
 *
 */
@Local
public interface CustomerService {

	/**
	 * 
	 * @return
	 */
	List<Customer> getAllCustomers();
}
