package com.AlfredoGomez.LibrarySystem;

public class LibraryController {
	
	public Book createbook(String title, String author, Long ISBN) {
		Book book = new Book(title,author,ISBN);
		Library library = Library.getInstance();
		library.addBookToStorage(book);
		return book;
	}
}
