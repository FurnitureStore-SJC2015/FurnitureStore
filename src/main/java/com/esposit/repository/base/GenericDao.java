package com.esposit.repository.base;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, PK extends Serializable> {

	PK save(T object);

	void update(T object);

	List<T> findAll();

	T findById(PK id);

	void delete(PK id);

	void delete(T object);
}
