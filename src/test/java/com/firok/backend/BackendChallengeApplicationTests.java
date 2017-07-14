package com.firok.backend;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.firok.backend.entity.Transaction;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BackendChallengeApplicationTests {

	RestTemplate restTemplate = new RestTemplate();

	@Test
	public void contextLoads() {
	}


	@Test
	public void testGetAllTransactionForMemoryFileAPI() {

		List<Transaction> transactions;
		transactions = new ArrayList<>(Arrays
				.asList(restTemplate.getForObject("http://localhost:8080/api/Transactions/", Transaction[].class)));

		assertTrue(transactions != null);

	}

	@Test
	public void testGetAllTransactionForMemoryDatabaseAPI() {

		List<Transaction> transactions;
		transactions = new ArrayList<>(Arrays
				.asList(restTemplate.getForObject("http://localhost:8080/api/Transactions/db", Transaction[].class)));

		assertTrue(transactions != null);

	}

	@Test
	public void testStatisticsAPI() {

		Transaction transaction = null;
		transaction = restTemplate.getForObject("http://localhost:8080/api/Statistics", Transaction.class);

		assertTrue(transaction != null);

	}

	@Test
	public void testStatisticsCaseDatabaseAPI() {

		Transaction transaction = null;
		transaction = restTemplate.getForObject("http://localhost:8080/api/Statistics/db", Transaction.class);

		assertTrue(transaction != null);

	}

}
