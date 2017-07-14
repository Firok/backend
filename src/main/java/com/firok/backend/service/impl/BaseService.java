package com.firok.backend.service.impl;

import java.io.Serializable;
import java.util.List;

import com.firok.backend.dao.IBaseDao;
import com.firok.backend.service.IBaseService;


public abstract  class BaseService<T, K extends Serializable> implements IBaseService<T, K> {

	protected abstract IBaseDao<T, K> getDao();

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
