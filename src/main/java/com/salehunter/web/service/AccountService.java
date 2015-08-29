package com.salehunter.web.service;

import java.util.List;

import javax.ejb.Local;

import com.salehunter.web.entity.Account;

/**
 * 
 * @author qct
 *
 */
@Local
public interface AccountService {

	/**
	 * 
	 * @return
	 */
	List<Account> getAllAccounts();
}
