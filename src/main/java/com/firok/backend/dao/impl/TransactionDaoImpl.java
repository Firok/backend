package com.firok.backend.dao.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.firok.backend.dao.TransactionDao;
import com.firok.backend.entity.Transaction;

@Transactional
@Repository
public class TransactionDaoImpl extends BaseDaoImpl<Transaction, Long> implements TransactionDao {

	private static final String fileName = "src/main/resources/transactions.txt";

	public TransactionDaoImpl() {
		super(Transaction.class);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> getAllSuccessTransaction() {
		try {
			return entityManager.createNamedQuery("transaction.getAllSuccessTransaction").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Transaction> getAllSuccessTransactionWithoutDatabase() {

		List<Transaction> allSuccessTransactions = new ArrayList<>();
		// get all success transactions i.e from the last 60 seconds by
		// filtering the list
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			stream.map(line -> line.split(";"))
			.filter(line -> line[2].equals("201"))
					.forEach(line -> allSuccessTransactions
							.add(new Transaction(Double.parseDouble(line[0]), Long.valueOf(line[1]))));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return allSuccessTransactions;
	}

	@Override
	public void saveTransaction(Transaction transaction) {

		BufferedWriter bWriter = null;
		FileWriter fWriter = null;

		try {
			fWriter = new FileWriter(fileName, true);
			bWriter = new BufferedWriter(fWriter);
			// format line as for csv pattern line
			String transactionToString = transaction.getAmount() + ";" + transaction.getTimestamp() + ";"
					+ transaction.getStatus();
			bWriter.append(transactionToString+"\n");
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {

			try {
				if (bWriter != null)
					bWriter.close();

				if (fWriter != null)
					fWriter.close();
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public List<Transaction> getAllTransactionFromFile() {
		List<Transaction> allTransactions = new ArrayList<>();
		// get all transactions from the file
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			stream.map(line -> line.split(";")).forEach(
					line -> allTransactions.add(new Transaction(Double.parseDouble(line[0]), Long.valueOf(line[1]))));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return allTransactions;
	}

}
