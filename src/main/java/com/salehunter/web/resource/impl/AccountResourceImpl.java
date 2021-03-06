/**
 * 
 */
package com.salehunter.web.resource.impl;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.salehunter.web.entity.Account;
import com.salehunter.web.entity.Authority;
import com.salehunter.web.entity.AuthorityRole;
import com.salehunter.web.entity.User;
import com.salehunter.web.repository.AccountRepository;
import com.salehunter.web.resource.AccountResource;

/**
 * @author qct
 *
 */
@Path("accounts")
@Produces({ "text/xml", "application/json" })
public class AccountResourceImpl implements AccountResource {

	@Inject
	private AccountRepository accountRepository;

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
		List<Account> allAccounts = accountRepository.getAllAccounts();
		System.out.println("size: " + allAccounts.size());
		return allAccounts;

	}

	@Override
	@POST
	@Path("/login")
	public Account login(User user) {
		return accountRepository.loginAccount(user);
	}

	@Override
	@POST
	@Path("/")
	public Account createAccount(Account account) {
		Authority authority = new Authority(account.getEmail(), AuthorityRole.ROLE_USER);
		account.getUser().setEmail(account.getEmail());
		account.getUser().getAuthorities().add(authority);
		account.setAccountId(buildNewAccountId());

		return accountRepository.createAccount(account);
	}

	private String buildNewAccountId() {
		String latestAccountId = accountRepository.getLatestAccountId();
		String numberPart = latestAccountId.substring(latestAccountId.indexOf("-") + 1);
		int accountId = Integer.valueOf(numberPart) + 1;

		return String.format("A-%04d", accountId);
	}
}
