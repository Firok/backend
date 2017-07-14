package com.firok.backend.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="transaction.getAllSuccessTransaction", query="SELECT t FROM Transaction t WHERE t.status=201")
})
public class Transaction extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID  = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private double amount;
	
	private long timestamp;
	
	private int status;
	
	

	public Transaction() {
		super();
	}
	
	public Transaction(double amount) {
		this.amount = amount;
	}
	

	public Transaction(double amount, long timestamp) {
		this.amount = amount;
		this.timestamp = timestamp;
	}
	
	
	public Transaction(double amount, long timestamp, int status) {
		this.amount = amount;
		this.timestamp = timestamp;
		this.status = status;
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (timestamp ^ (timestamp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (id != other.id)
			return false;
		if (timestamp != other.timestamp)
			return false;
		return true;
	}
	
	
	/**
	 * get all transaction in memory without database
	 * @return
	 */
	public static List<Transaction> getAllTransaction(){
		
		List<Transaction> transactions =new ArrayList<>();
		transactions.add(new Transaction(12.3,126234720000l,204));
		transactions.add(new Transaction(16.3,124794,201));
		transactions.add(new Transaction(14.3,12423214,201));
		transactions.add(new Transaction(10.3,1242320,201));
		transactions.add(new Transaction(15.3,12423200l,204));
		transactions.add(new Transaction(11.3,12423200l,204));
		transactions.add(new Transaction(20,54000l,201));
		transactions.add(new Transaction(21.3,1450200l,201));
		transactions.add(new Transaction(25.3,15000l,201));
		transactions.add(new Transaction(30,1712200l,201));
		
		return transactions;
	}
	
	
	

}
