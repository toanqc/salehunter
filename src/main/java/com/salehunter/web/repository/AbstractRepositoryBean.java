package com.salehunter.web.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * 
 * @author qct
 *
 */
@Stateless
public abstract class AbstractRepositoryBean<T> {

	@PersistenceContext
	private EntityManager entityManager;

	public <E> E create(E e) {
		entityManager.persist(e);
		return e;
	}

	public <E> E update(E e) {
		return entityManager.merge(e);
	}

	public <E> void delete(Class<E> clazz, long id) {
		entityManager.remove(entityManager.find(clazz, id));
	}

	public <E> E find(Class<E> clazz, long id) {
		return entityManager.find(clazz, id);
	}

	public <E> List<E> find(Class<E> clazz, String strQuery, int min, int max) {
		TypedQuery<E> query = entityManager.createQuery(strQuery, clazz);
		return queryRange(query, min, max).getResultList();
	}

	public <E> List<E> namedFind(Class<E> clazz, String strQuery, int min, int max) {
		TypedQuery<E> query = entityManager.createQuery(strQuery, clazz);
		return queryRange(query, min, max).getResultList();
	}

	private static <E> TypedQuery<E> queryRange(TypedQuery<E> query, int min, int max) {
		if (max >= 0) {
			query.setMaxResults(max);
		}
		if (min >= 0) {
			query.setFirstResult(min);
		}
		return query;
	}

	public T getFirstElement(List<T> list) {
		if (list == null || list.isEmpty()) {
			return null;
		}

		return list.get(0);
	}
}
