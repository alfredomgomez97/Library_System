package com.AlfredoGomez.LibrarySystem;

public class FactoryLibrarian {
	private Librarian librarian;
	
	public Librarian createLibrarian(String name, float pay) {
		librarian = new Librarian(name , pay);
		return librarian;
	}
}
