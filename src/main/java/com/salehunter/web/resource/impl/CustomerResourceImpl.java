/**
 * 
 */
package com.salehunter.web.resource.impl;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.salehunter.web.bean.CustomerBeanLocal;
import com.salehunter.web.entity.Customer;
import com.salehunter.web.resource.CustomerResource;

/**
 * @author qct
 *
 */
@Path("customers")
public class CustomerResourceImpl implements CustomerResource {

	@Inject
	private CustomerBeanLocal customerRepository;
	
	
	@GET
	@Path("/{param}")
	@Override
	public Response printMessage(@PathParam("param") String msg) {
		String result = "Restful example : " + msg;
		return Response.status(200).entity(result).build();
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.getAllCustomers();
	}
}
