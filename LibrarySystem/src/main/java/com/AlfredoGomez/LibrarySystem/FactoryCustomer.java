package com.AlfredoGomez.LibrarySystem;

import java.util.ArrayList;

public class FactoryCustomer {
	Customer customer;
	private static long idAssign = 100000;
	
	public Customer createCustomer(String name ,String address ,Long routingNumber) {
		ArrayList<Book> checkedOutBooks = new ArrayList<>();
		return customer = new Customer(name, address, routingNumber, idGenerator(), checkedOutBooks);
	}
	public long idGenerator() {
		idAssign = idAssign + 7;
		return idAssign;
	}
}
