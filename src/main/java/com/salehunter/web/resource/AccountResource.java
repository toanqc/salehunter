package com.salehunter.web.resource;

import java.util.List;

import javax.ws.rs.core.Response;

import com.salehunter.web.entity.Account;
import com.salehunter.web.entity.User;

/**
 * 
 * @author qct
 *
 */
public interface AccountResource {

	Response printMessage(String msg);

	/**
	 * 
	 * @return
	 */
	List<Account> getAllAccounts();

	/**
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	Account login(User user);

	/**
	 * 
	 * @param account
	 * @return
	 */
	Account createAccount(Account account);
}
