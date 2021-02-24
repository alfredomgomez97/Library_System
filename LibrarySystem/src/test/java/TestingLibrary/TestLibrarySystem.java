package TestingLibrary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.AlfredoGomez.LibrarySystem.Book;
import com.AlfredoGomez.LibrarySystem.Customer;
import com.AlfredoGomez.LibrarySystem.FactoryCustomer;
import com.AlfredoGomez.LibrarySystem.FactoryLibrarian;
import com.AlfredoGomez.LibrarySystem.Librarian;
import com.AlfredoGomez.LibrarySystem.Library;
import com.AlfredoGomez.LibrarySystem.LibraryController;

class TestLibrarySystem {
	FactoryCustomer factoryCustomer;
	FactoryLibrarian factoryLibrarian;
	LibraryController controller;
	Librarian librarian;
	Library library;
	Customer customerMade;
	
	
	@Mock
	Librarian librarianMocked = Mockito.mock(Librarian.class);
	Book bookMocked = Mockito.mock(Book.class);
	
	@BeforeEach
	void setUp() throws Exception {
		factoryCustomer = new FactoryCustomer();
		factoryLibrarian = new FactoryLibrarian();
		String nameLibrarian = "Alfredo";
		int libraryId = 1234;
		librarian = new Librarian(nameLibrarian, libraryId);
		controller = new LibraryController();
		String customerName = "Joseph";
		String customerAddress = "100 Money Ave ";
		long customerId = 12345;
		long customerRoutingNumber = 100028;
		customerMade = factoryCustomer.createCustomer(customerName, customerAddress, customerRoutingNumber, customerId);
	}

	@Test
	void TestCreateACustomerFromFactoryOfCreateCustomer() {
		//Arrange & Act
		Customer actualCustomer  = factoryCustomer.createCustomer(Mockito.anyString(),Mockito.anyString(),Mockito.anyLong(), Mockito.anyLong());
		
		//Assert
		boolean statement = false;
		if (actualCustomer instanceof Customer) {
			statement = true;
		}
		assertTrue(statement);
	}
	@Test
	void CreateALibrarianFromFactoryOfCreateLibrarian(){
		//Arrange & Act
		Librarian actualLibrarian = factoryLibrarian.createLibrarian(Mockito.anyString(),Mockito.anyFloat());
		//Assert
		boolean statement = false;
		if (actualLibrarian instanceof Librarian) {
			statement = true;
		}
		assertTrue(statement);
	}

	@Test
	void testCreateABookAndAddToTheSingletonLibrary(){
		//Arrange
		String expectedTitle = "Mars";
		String expectedSAuthor = "Alfredo Gomez";
		long expectedISBN = 12345;
		Book expectedBook = new Book(expectedTitle, expectedSAuthor, expectedISBN);
		//Act
		controller.createbook(expectedTitle, expectedSAuthor, expectedISBN);
		//Assert
		Library library = Library.getInstance();
		boolean foundExpectedBook = false;
		for(Book book : library.getStorage()) {
			if(expectedBook.equals(book)) {
				foundExpectedBook = true;
			}
		}
		assertTrue(foundExpectedBook);
	}
	@Test
	void LibrarianChecksOutBookToCustomer() {
		//Arrange
		String expectedTitle = "Mars";
		String expectedSAuthor = "Alfredo Gomez";
		long expectedISBN = 12345;
		Book expectedBook = new Book(expectedTitle, expectedSAuthor, expectedISBN);
		Library library = Library.getInstance();
		library.addBookToStorage(expectedBook);
		//Act
		librarian.checkOutBookToCustomer(expectedBook.getISBN(),customerMade);
		//Assert
		boolean found = false;
		for(Book book: customerMade.getCheckoutBooks()) {
			if (expectedBook.equals(book)) {
				found = true;
			}
		}
		assertTrue(found);
	}

}
