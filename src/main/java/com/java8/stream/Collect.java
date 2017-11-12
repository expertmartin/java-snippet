package com.java8.stream;
/*example queries of what you’ll be able to do using collect and collectors:
Group a list of transactions by currency to obtain the sum of the values of all transactions with that
currency (returning a Map<Currency, Integer>)
Partition a list of transactions into two groups: expensive and not expensive (returning a
Map<Boolean, List<Transaction>>)
Create multilevel groupings such as grouping transactions by cities and then further categorizing
by whether they’re expensive or not (returning a Map<String, Map<Boolean,
List<Transaction>>>)*/

public class Collect {
	public static void main(String[] args) {

		System.out.println(" Processor number: " + Runtime.getRuntime().availableProcessors());
	}

	public static void group() {
//		Map<Currency, List<Transaction>> transactionsByCurrencies = transactions.stream().collect(groupingBy(Transaction::getCurrency));
	}
		
}
