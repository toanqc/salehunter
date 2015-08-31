/**
 * 
 */
package com.salehunter.web.repository.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.apache.commons.codec.digest.DigestUtils;

import com.salehunter.web.entity.Account;
import com.salehunter.web.entity.User;
import com.salehunter.web.repository.AccountRepository;
import com.salehunter.web.repository.AbstractRepositoryBean;

/**
 * @author qct
 *
 */
@Stateless
public class AccountRepositoryBean extends AbstractRepositoryBean<Account>implements AccountRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Account> getAllAccounts() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Account> cq = cb.createQuery(Account.class);
		Root<Account> account = cq.from(Account.class);
		cq.select(account);
		TypedQuery<Account> q = entityManager.createQuery(cq);
		List<Account> allAccounts = q.getResultList();

		return allAccounts;
	}

	@Override
	public Account loginAccount(User user) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Account> criteriaQuery = criteriaBuilder.createQuery(Account.class);
		Root<Account> accountRoot = criteriaQuery.from(Account.class);
		Join<Account, User> userRoot = accountRoot.<Account, User> join("user");
		criteriaQuery.select(accountRoot);
		criteriaQuery.where(criteriaBuilder.equal(userRoot.<String> get("email"), user.getEmail()));

		String hasedPassword = DigestUtils.sha256Hex(user.getPassword());
		criteriaQuery.where(criteriaBuilder.equal(userRoot.<String> get("password"), hasedPassword));

		TypedQuery<Account> query = entityManager.createQuery(criteriaQuery);
		List<Account> accountList = query.getResultList();

		return this.getFirstElement(accountList);
	}
}
