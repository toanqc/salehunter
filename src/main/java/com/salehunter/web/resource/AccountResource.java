package com.salehunter.web.resource;

import java.util.List;

import javax.ws.rs.core.Response;

import com.salehunter.web.entity.Account;

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
}
