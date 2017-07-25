package com.firok.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firok.backend.dao.BaseDao;
import com.firok.backend.dao.TransactionDao;
import com.firok.backend.entity.Transaction;
import com.firok.backend.service.TransactionService;

@Service
public class TransactionServiceImpl extends BaseServiceImpl<Transaction, Long> implements TransactionService {

	@Autowired
	private TransactionDao transactionDao;

	@Override
	protected BaseDao<Transaction, Long> getDao() {
		return transactionDao;
	}

	@Override
	public List<Transaction> getAllSuccessTransaction() {
		return transactionDao.getAllSuccessTransaction();
	}

	@Override
	public List<Transaction> getAllSuccessTransactionWithoutDatabase() {
		return transactionDao.getAllSuccessTransactionWithoutDatabase();
	}

	@Override
	public void saveTransaction(Transaction transaction) {
		 transactionDao.saveTransaction(transaction);

	}

	@Override
	public List<Transaction> getAllTransactionFromFile() {
		 return transactionDao.getAllTransactionFromFile();
	}

}
