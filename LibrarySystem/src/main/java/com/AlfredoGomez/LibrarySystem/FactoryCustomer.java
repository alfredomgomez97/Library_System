package com.AlfredoGomez.LibrarySystem;

import java.util.ArrayList;

public class FactoryCustomer {
	Customer customer;
	
	public Customer createCustomer(String name ,String address ,Long routingNumber,Long customerId) {
		ArrayList<Book> checkedOutBooks = new ArrayList<>();
		return customer = new Customer(name, address, routingNumber, customerId, checkedOutBooks);
	}
}
