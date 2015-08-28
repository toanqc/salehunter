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

import com.salehunter.web.entity.Customer;
import com.salehunter.web.service.CustomerService;

/**
 * @author qct
 *
 */
@Stateless
public class CustomerServiceBean implements CustomerService {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Customer> getAllCustomers() {
		Object singleResult = entityManager.createNativeQuery("SELECT count(*) from CUSTOMER c").getSingleResult();
		System.out.println("object: " + singleResult);

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
		Root<Customer> customer = cq.from(Customer.class);
		cq.select(customer);
		TypedQuery<Customer> q = entityManager.createQuery(cq);
		List<Customer> allCustomers = q.getResultList();
		System.out.println("size: " + allCustomers.size());

		return allCustomers;
	}
}
