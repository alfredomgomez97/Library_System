package com.AlfredoGomez.LibrarySystem;

import java.util.ArrayList;

public class Customer {
	private String name ;
	private String address ;
	private Long routingNumber;
	private Long customerId;
	private ArrayList<Book> booksCheckedOut = new ArrayList<>();
	
	
	public Customer(String name, String address, Long routingNumber, Long customerId, ArrayList<Book> checkedOutBooks) {
		super();
		this.name = name;
		this.address = address;
		this.routingNumber = routingNumber;
		this.customerId = customerId;
		this.booksCheckedOut = checkedOutBooks;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getRoutingNumber() {
		return routingNumber;
	}
	public void setRoutingNumber(Long routingNumber) {
		this.routingNumber = routingNumber;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public ArrayList<Book> getCheckoutBooks() {
		return booksCheckedOut;
	}
	public void setCheckoutBooks(ArrayList<Book> checkoutBooks) {
		this.booksCheckedOut = checkoutBooks;
	}
	public Book getBook(String ISBN) {
		for (Book book : booksCheckedOut) {
			if(book.getTitle().equals(ISBN)){
				return book;
			}
		}
		return null;
	}
	
	
}
