package com.salehunter.web.repository;

import java.util.List;

import javax.ejb.Local;

import com.salehunter.web.entity.Account;
import com.salehunter.web.entity.User;

/**
 * 
 * @author qct
 *
 */
@Local
public interface AccountRepository {

	/**
	 * 
	 * @return
	 */
	List<Account> getAllAccounts();

	/**
	 * 
	 * @param user
	 * @return
	 */
	Account loginAccount(User user);
}
