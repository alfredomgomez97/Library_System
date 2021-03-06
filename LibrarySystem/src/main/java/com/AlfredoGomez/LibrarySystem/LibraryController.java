package com.AlfredoGomez.LibrarySystem;

import java.util.ArrayList;
import java.util.List;

public class LibraryController {
	private ArrayList<Customer> allCustomers = new ArrayList<>();
	
	public Book createbook(String title, String author, Long ISBN) {
		Book book = new Book(title,author,ISBN);
		Library library = Library.getInstance();
		library.addBookToStorage(book);
		return book;
	}
	
	public void addCustomer(Customer customer) {
		allCustomers.add(customer);
	}
	
	public List<Customer> getAllCustomers(){
		return allCustomers;
	}


	
}
