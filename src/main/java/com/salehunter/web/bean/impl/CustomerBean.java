/**
 * 
 */
package com.salehunter.web.bean.impl;

import java.util.List;

import javax.ejb.Stateless;

import com.salehunter.web.bean.CustomerBeanLocal;
import com.salehunter.web.entity.Customer;

/**
 * @author qct
 *
 */
@Stateless
public class CustomerBean implements CustomerBeanLocal {

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

}
