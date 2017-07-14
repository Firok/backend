package com.firok.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firok.backend.dao.IBaseDao;
import com.firok.backend.dao.ITransactionDao;
import com.firok.backend.entity.Transaction;
import com.firok.backend.service.ITransactionService;

@Service
public class TransactionService extends BaseService<Transaction, Long> implements ITransactionService {

	@Autowired
	private ITransactionDao transactionDao;

	@Override
	protected IBaseDao<Transaction, Long> getDao() {
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
