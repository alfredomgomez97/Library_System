package com.AlfredoGomez.LibrarySystem;

public class Librarian {
	private String name;
	private float pay;
	
	
	public Librarian(String name, float pay) {
		super();
		this.name = name;
		this.pay = pay;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPay() {
		return pay;
	}
	public void setPay(float pay) {
		this.pay = pay;
	}
	public void addBookToDataBase(Book book) {
		Library library = Library.getInstance();	
		library.addBookToStorage(book);
	}
	public void checkOutBookToCustomer(long ISBN, Customer customer) {
		Library library = Library.getInstance();
		customer.getCheckoutBooks().add(library.getBook(ISBN));
		
	}
}
