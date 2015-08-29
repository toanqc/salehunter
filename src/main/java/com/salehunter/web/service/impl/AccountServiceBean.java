/**
 * 
 */
package com.salehunter.web.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.salehunter.web.entity.Account;
import com.salehunter.web.service.AccountService;

/**
 * @author qct
 *
 */
@Stateless
public class AccountServiceBean implements AccountService {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Account> getAllAccounts() {
		Object singleResult = entityManager.createNativeQuery("SELECT count(*) from Account a").getSingleResult();
		System.out.println("object: " + singleResult);

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Account> cq = cb.createQuery(Account.class);
		Root<Account> account = cq.from(Account.class);
		cq.select(account);
		TypedQuery<Account> q = entityManager.createQuery(cq);
		List<Account> allAccounts = q.getResultList();
		System.out.println("size: " + allAccounts.size());

		return allAccounts;
	}
}
