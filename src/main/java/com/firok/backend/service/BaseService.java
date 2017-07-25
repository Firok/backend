package com.firok.backend.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T, K extends Serializable> {

	/**
	 * get all rows from table
	 * @return list of all data from any specific table
	 */
	List<T> findAll();
	
	/**
	 * get a row from a table
	 * @param k id
	 * @return a row from a table
	 */
	T find(K k);
	
	/**
	 * add a new record 
	 * @param t entity
	 */
	void add(T t);
	
	/**
	 * update a row
	 * @param t entity
	 * @return entity
	 */
	T update(T t);
	
	/**
	 * delete a row from a table
	 * @param t entity
	 */
	void delete(T t);
	
	/**
	 * delete a row from a table
	 * @param k id
	 */
	void delete(K k);
}
