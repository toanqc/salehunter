package com.salehunter.web.bean;

import java.util.List;

import javax.ejb.Local;

import com.salehunter.web.entity.Customer;

/**
 * 
 * @author qct
 *
 */
@Local
public interface CustomerBeanLocal {

	/**
	 * 
	 * @return
	 */
	List<Customer> getAllCustomers();
}
