package com.firok.backend.service.impl;

import java.io.Serializable;
import java.util.List;

import com.firok.backend.dao.BaseDao;
import com.firok.backend.service.BaseService;


public abstract  class BaseServiceImpl<T, K extends Serializable> implements BaseService<T, K> {

	protected abstract BaseDao<T, K> getDao();

	/**
	 * get all rows from table
	 * @return list of all data from any specific table
	 */
	@Override
	public List<T> findAll() {
		return getDao().findAll();
	}

	/**
	 * 
	 */
	@Override
	public T find(K k) {
		return getDao().find(k);
	}

	@Override
	public void add(T t) {
		getDao().add(t);
	}

	@Override
	public T update(T t) {
		return getDao().update(t);
	}

	@Override
	public void delete(T t) {
		getDao().delete(t);
		
	}

	@Override
	public void delete(K k) {
		getDao().delete(k);
		
	}
}
