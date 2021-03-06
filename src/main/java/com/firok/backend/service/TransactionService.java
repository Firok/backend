package com.firok.backend.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.firok.backend.entity.Transaction;

@Repository
public interface TransactionService extends BaseService<Transaction, Long> {

	/**
	 * get All Success transaction i.e from the last 60 seconds in-memory database
	 * @return
	 */
	List<Transaction> getAllSuccessTransaction();
	
	/**
	 * get All Success Transaction i.e from the last 60 seconds without database
	 * @return
	 */
	List<Transaction> getAllSuccessTransactionWithoutDatabase();
	
	/**
	 * save transaction in memory without database
	 * here the choice is file txt
	 * @param transaction
	 */
	void saveTransaction(Transaction transaction);
	
	/**
	 * get All Transaction i.e from the file in memory
	 * @return
	 */
	List<Transaction> getAllTransactionFromFile();
}
