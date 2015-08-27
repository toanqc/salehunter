/**
 * 
 */
package com.salehunter.web.service.impl;

import java.util.List;

import javax.ejb.Stateless;

import com.salehunter.web.entity.Customer;
import com.salehunter.web.service.CustomerService;

/**
 * @author qct
 *
 */
@Stateless
public class CustomerServiceBean implements CustomerService {

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

}
