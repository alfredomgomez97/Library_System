package com.AlfredoGomez.LibrarySystem;

public class Book {
	private String title;
	private String author;
	private Long ISBN;
	
	public Book(String title, String author, Long iSBN) {
		super();
		this.title = title;
		this.author = author;
		ISBN = iSBN;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public long getISBN() {
		return ISBN;
	}
	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}
	
	@Override
	public boolean equals(Object book) { 
	
	if(book == this) {
		return true;
	}
	 if (!(book instanceof Book)) { 
            return false; 
        } 
	  
	  Book current = (Book) book;
	  return title.equals(current.getTitle()) && author.equals(current.getAuthor())
			 && Long.compare(ISBN, current.ISBN) == 0;
	}
	
}
