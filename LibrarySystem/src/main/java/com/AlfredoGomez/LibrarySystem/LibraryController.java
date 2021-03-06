package com.AlfredoGomez.LibrarySystem;

import java.util.ArrayList;
import java.util.List;

public class LibraryController {
	private static ArrayList<Customer> allCustomers = new ArrayList<>();
	private static ArrayList<Librarian> allLibrarians = new ArrayList<>();
	
	public Book createbook(String title, String author, Long ISBN) {
		Book book = new Book(title,author,ISBN);
		Library library = Library.getInstance();
		library.addBookToStorage(book);
		return book;
	}
	
	public void addCustomer(Customer customer) {
		allCustomers.add(customer);
	}
	public void addLibrarian(Librarian librarian) {
		allLibrarians.add(librarian);
	}
	
	public List<Customer> getAllCustomers(){
		return allCustomers;
	}
	public List<Librarian> getAllLibrains(){
		return allLibrarians;
	}

	
}
