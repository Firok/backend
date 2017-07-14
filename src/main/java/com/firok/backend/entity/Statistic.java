package com.firok.backend.entity;

import java.io.Serializable;

public class Statistic implements Serializable{
	
	private static final long serialVersionUID  = 1L;
	
	private double sum;
	
	private double avg;
	
	private double max;
	
	private double min;
	
	private  long count;

	public Statistic(double sum, double avg, double max, double min, long count) {
		this.sum = sum;
		this.avg = avg;
		this.max = max;
		this.min = min;
		this.count = count;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}
	
	
	
	

}
