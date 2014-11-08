package com.app.stocksassignment;

public class Stock {
	String price;
	String volume;
	String yield;
	String change;
	String pChange;
	
	public Stock(){
		
	}
	
	public Stock(String price, String volume, String yield,
			String change, String pChange) {
		this.price = price;
		this.volume = volume;
		this.yield = yield;
		this.change = change;
		this.pChange = pChange;
	}

}
