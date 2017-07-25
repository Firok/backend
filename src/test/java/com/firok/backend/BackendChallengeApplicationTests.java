package com.firok.backend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.firok.backend.entity.Transaction;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BackendChallengeApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void contextLoads() {
		String first="bate";
		int index;
		if(first.contains("c")){
			index =first.indexOf('c');
			if(index==first.length()-1)
				first=first.substring(index);
			else if(index+1<first.length())
				first=first.substring(index,index+1);
		}
		System.out.println(first.substring(0,1));
	}

	/**
	 * test Get All Transaction For Memory File API
	 */
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

	@Test
	public void SaveTransactionCaseDatabaseAPI() {

		Transaction transaction = new Transaction(142, 456317845, 201);
		int status = restTemplate.postForObject("http://localhost:8080/api/Transactions/db", transaction, Integer.class);

		assertEquals(201, status);

	}

}
