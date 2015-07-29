package com.exposit.repository.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.NonUniqueObjectException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository()
public class AbstractHibernateDao<T, PK extends Serializable> implements
		HibernateDao<T, PK> {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	protected Class<T> getGenericEntityClass() {
		ParameterizedType parameterizedType = (ParameterizedType) getClass()
				.getGenericSuperclass();
		return (Class<T>) parameterizedType.getActualTypeArguments()[0];
	}

	@SuppressWarnings("unchecked")
	@Override
	public PK save(T object) {
		return (PK) getSession().save(object);
	}

	@Override
	public void update(T object) {
		getSession().update(object);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		Criteria criteria = getSession().createCriteria(
				this.getGenericEntityClass());
		return (List<T>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(PK id) {
		return (T) getSession().get(this.getGenericEntityClass(), id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void delete(PK id) {
		T persistentObject = (T) getSession().load(
				this.getGenericEntityClass(), id);
		try {
			getSession().delete(persistentObject);
		} catch (NonUniqueObjectException e) {
			// in a case of detached object
			T instance = (T) getSession().merge(persistentObject);
			getSession().delete(instance);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public void delete(T object) {
		try {
			getSession().delete(object);
		} catch (NonUniqueObjectException e) {
			// in a case of detached object
			T instance = (T) getSession().merge(object);
			getSession().delete(instance);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByCriteria(Criterion criterion) {
		Criteria criteria = getSession().createCriteria(
				this.getGenericEntityClass());
		criteria.add(criterion);
		return (List<T>) criteria.list();
	}

}
