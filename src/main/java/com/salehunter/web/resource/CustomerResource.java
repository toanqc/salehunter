package com.salehunter.web.resource;

import java.util.List;

import javax.ws.rs.core.Response;

import com.salehunter.web.entity.Customer;

/**
 * 
 * @author qct
 *
 */
public interface CustomerResource {

	Response printMessage(String msg);

	/**
	 * 
	 * @return
	 */
	List<Customer> getAllCustomers();
}
