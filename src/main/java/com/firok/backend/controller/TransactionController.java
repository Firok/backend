package com.firok.backend.controller;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.firok.backend.entity.Transaction;
import com.firok.backend.service.ITransactionService;

@RestController
@RequestMapping("/Transactions")
public class TransactionController {

	private static final Logger log = LoggerFactory.getLogger(TransactionController.class);

	@Autowired
	private ITransactionService transactionService;

	/**
	 * get all transaction from file in memory
	 * 
	 * @return
	 */
	@GetMapping
	public List<Transaction> getAllTransaction() {
		return transactionService.getAllTransactionFromFile();
	}

	/**
	 * get all transaction in case of memory database
	 * 
	 * @return
	 */
	@GetMapping("/db")
	public List<Transaction> getAllTransactionFromDatabase() {
		return transactionService.findAll();
	}

	/**
	 * //in case of memory without database
	 * 
	 * @param transaction
	 * @return status
	 */
	@PostMapping
	public Integer addTransaction(@RequestBody Transaction transaction) {
		// save in file memory
		transactionService.saveTransaction(transaction);
		return transaction.getStatus();
	}

	/**
	 * //save transaction in the database in case of memory database
	 * 
	 * @param transaction
	 * @return status
	 */
	@PostMapping("/db")
	public Integer addTransactionToDatabase(@RequestBody Transaction transaction) {
		// save transaction in the database in case of memory database
		transactionService.add(transaction);
		return transaction.getStatus();
	}

	//testing /transactions api
	@PostMapping("/post")
	public Integer postTransactionAmount(@RequestParam String amount) {
		// current time in UTC time zone
		Instant before = Instant.now();
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("Transaction successful");
		Integer status = null;
		Instant after = Instant.now();
		// get time from the starting till now
		Instant timeofEpoch = Instant.from(before);
		// calculate duration
		Duration duration = Duration.between(before, after);
		long convertDurationToMillis = duration.toMillis();
		// update status
		status = (convertDurationToMillis <= 60000 ? 201 : 204);
		// update amount and timestamp in millis
		Transaction transaction = new Transaction(Double.parseDouble(amount), timeofEpoch.getEpochSecond(), status);

		status = restTemplate.postForObject("http://localhost:8080/api/Transactions/", transaction, Integer.class);
		log.info(transaction.toString() + transaction.getTimestamp() + " " + status);
		return status;
	}

}
