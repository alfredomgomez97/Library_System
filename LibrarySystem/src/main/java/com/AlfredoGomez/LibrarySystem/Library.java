package com.AlfredoGomez.LibrarySystem;


import java.util.ArrayList;


public class Library {
	private static Library library = new Library();
	private ArrayList<Book> storage = new ArrayList<>();
	private ArrayList<String> transactionHistory = new ArrayList<>(); 
	private Library() {
		storage = new ArrayList<Book>();
	}
	public static Library getInstance() {
		if(library == null) {
		library = new Library();
		}
		return library;
	}
	public void addBookToStorage(Book book) {
		storage.add(book);
	}
	public ArrayList<Book> getStorage() {
		return storage;
	}
	public ArrayList<String> getTransactionHistory() {
		return transactionHistory;
	}
	public Book getBook(long ISBN) {
		for (Book book : storage) {
			if(ISBN == book.getISBN()) {
				return book;
			}
		}
		return null;
	}

}
