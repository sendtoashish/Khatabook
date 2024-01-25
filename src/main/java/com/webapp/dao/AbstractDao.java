package com.webapp.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * Abstract DAO Interface for Simple Spring MVC CRUD App
 * 
 */
public class AbstractDao<PK extends Serializable, T> {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("rawtypes")
	private final Class persistentClass;

	@SuppressWarnings("rawtypes")
	public AbstractDao() {
		this.persistentClass = (Class) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public T getByKey(PK key) {
		return (T) getSession().get(persistentClass, key);
	}

	public void persist(T entity) {
		getSession().persist(entity);
	}

	public void update(T entity) {
		getSession().update(entity);
	}

	public void delete(T entity) {
		getSession().delete(entity);
	}

	@SuppressWarnings("deprecation")
	protected Criteria createEntityCriteria() {
		return getSession().createCriteria(persistentClass);
	}

}
