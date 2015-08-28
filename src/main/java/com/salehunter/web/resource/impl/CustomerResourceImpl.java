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

import com.salehunter.web.entity.Customer;
import com.salehunter.web.resource.CustomerResource;
import com.salehunter.web.service.CustomerService;

/**
 * @author qct
 *
 */
@Path("customers")
public class CustomerResourceImpl implements CustomerResource {

	@Inject
	private CustomerService customerService;

	@Override
	@GET
	@Path("/{param}")
	public Response printMessage(@PathParam("param") String msg) {
		String result = "Restful example : " + msg;
		return Response.status(200).entity(result).build();
	}

	@Override
	@GET
	@Path("/")
	public List<Customer> getAllCustomers() {
		List<Customer> allCustomers = customerService.getAllCustomers();
		System.out.println("size: " + allCustomers.size());
		return allCustomers;

	}
}
