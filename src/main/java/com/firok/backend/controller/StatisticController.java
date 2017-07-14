package com.firok.backend.controller;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firok.backend.entity.Statistic;
import com.firok.backend.entity.Transaction;
import com.firok.backend.service.ITransactionService;



@RestController
@RequestMapping("/Statistics")
public class StatisticController {

	@Autowired
	private ITransactionService transactionService;

	/**
	 * get Statistic case memory file
	 * 
	 * @return
	 */
	@GetMapping
	public Statistic getStatisticCaseMemoryFile() {

		// get all success transaction in case of memory database
		// List<Transaction> transactionValues =
		// transactionService.getAllSuccessTransaction();
		
		// get all success transaction in case of memory without database
		List<Transaction> transactionValues = transactionService.getAllSuccessTransactionWithoutDatabase();
		DoubleSummaryStatistics stats = (!transactionValues.isEmpty() || transactionValues != null)
				? transactionValues.stream().collect(Collectors.summarizingDouble(Transaction::getAmount)) : null;

		Statistic statistic = (stats != null) ? new Statistic(stats.getSum(), stats.getAverage(), stats.getMax(),
				stats.getMin(), transactionValues.size()) : null;

		return statistic;
	}

	/**
	 * get Statistic case database
	 * 
	 * @return
	 */
	@GetMapping("/db")
	public Statistic getAllStatisticCaseDatabase() {

		// get all success transaction in case of memory database
		// List<Transaction> transactionValues =
		// transactionService.getAllSuccessTransaction();
		
		// get all success transaction in case of memory without database
		List<Transaction> transactionValues = transactionService.getAllSuccessTransactionWithoutDatabase();
		DoubleSummaryStatistics stats = (!transactionValues.isEmpty() || transactionValues != null)
				? transactionValues.stream().collect(Collectors.summarizingDouble(Transaction::getAmount)) : null;

		Statistic statistic = (stats != null) ? new Statistic(stats.getSum(), stats.getAverage(), stats.getMax(),
				stats.getMin(), transactionValues.size()) : null;

		return statistic;
	}

}
