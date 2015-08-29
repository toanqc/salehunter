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

import com.salehunter.web.entity.Account;
import com.salehunter.web.resource.AccountResource;
import com.salehunter.web.service.AccountService;

/**
 * @author qct
 *
 */
@Path("accounts")
public class AccountResourceImpl implements AccountResource {

	@Inject
	private AccountService accountService;

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
	public List<Account> getAllAccounts() {
		List<Account> allAccounts = accountService.getAllAccounts();
		System.out.println("size: " + allAccounts.size());
		return allAccounts;

	}
}
