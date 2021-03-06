package com.AlfredoGomez.LibrarySystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Swing {

	private JFrame frame;
	private JTextField customerNameTextField;
	private JTextField customerAddressTextField;
	private JTextField customerRoutingTextField;
	private JTextField librarianNameTextField;
	private JTextField librarianPayTextField;
	private JTextField titleTextField;
	private JTextField authorTextField;
	private JTextField ISBNTextField;
	private LibraryController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Swing window = new Swing();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Swing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		FactoryCustomer factoryCustomer = new FactoryCustomer();
		FactoryLibrarian factoryLibrarian = new FactoryLibrarian();
		LibraryController controller = new LibraryController();
		
		frame = new JFrame();
		frame.setBounds(150, 150, 450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel customerCreatedSuccess = new JLabel("");
		customerCreatedSuccess.setBounds(10, 70, 383, 21);
		frame.getContentPane().add(customerCreatedSuccess);
		

		JButton CreateACustomerButton = new JButton("Create a Customer");
		CreateACustomerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customerNameTextField.getText();
				customerAddressTextField.getText();
				customerRoutingTextField.getText();
				Customer customer = factoryCustomer.createCustomer(customerNameTextField.getText(), customerAddressTextField.getText(), Long.parseLong(customerRoutingTextField.getText()));
				customerCreatedSuccess.setText("Customer createdSuccesfully " + customer.getName());
			}
		});
		CreateACustomerButton.setBounds(10, 10, 154, 21);
		frame.getContentPane().add(CreateACustomerButton);
		
		JLabel librarianCreatedSuccess = new JLabel("");
		librarianCreatedSuccess.setBounds(10, 200, 383, 20);
		frame.getContentPane().add(librarianCreatedSuccess);
		
		JButton librarianButton = new JButton("Create Librarian");
		librarianButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Librarian librarian = factoryLibrarian.createLibrarian(librarianNameTextField.getText(), Float.parseFloat(librarianPayTextField.getText()));
				librarianCreatedSuccess.setText("Librarian " + librarian.getName() + " created Succesfully" );
				controller.addLibrarian(librarian);
			}
		});
		librarianButton.setBounds(10, 132, 154, 21);
		frame.getContentPane().add(librarianButton);
		
		JLabel BookSuccess = new JLabel("");
		BookSuccess.setBounds(10, 332, 383, 21);
		frame.getContentPane().add(BookSuccess);
		
		
		JButton createBookButton = new JButton("Create Book");
		createBookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookSuccess.setText("The book was created Succesfully");
			}
		});
		createBookButton.setBounds(10, 230, 154, 21);
		frame.getContentPane().add(createBookButton);
		
		customerNameTextField = new JTextField();
		customerNameTextField.setBounds(297, 11, 96, 19);
		frame.getContentPane().add(customerNameTextField);
		customerNameTextField.setColumns(10);
		
		JLabel customerNameLabel = new JLabel("Name");
		customerNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		customerNameLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		customerNameLabel.setBounds(242, 14, 45, 13);
		frame.getContentPane().add(customerNameLabel);
		
		customerAddressTextField = new JTextField();
		customerAddressTextField.setBounds(87, 41, 96, 19);
		frame.getContentPane().add(customerAddressTextField);
		customerAddressTextField.setColumns(10);
		
		JLabel AddressLabel = new JLabel("Address");
		AddressLabel.setHorizontalAlignment(SwingConstants.CENTER);
		AddressLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		AddressLabel.setBounds(20, 44, 57, 13);
		frame.getContentPane().add(AddressLabel);
		
		customerRoutingTextField = new JTextField();
		customerRoutingTextField.setBounds(297, 41, 96, 19);
		frame.getContentPane().add(customerRoutingTextField);
		customerRoutingTextField.setColumns(10);
		
		JLabel customerRoutingNumberTextField = new JLabel("Routing Number");
		customerRoutingNumberTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		customerRoutingNumberTextField.setBounds(202, 44, 85, 13);
		frame.getContentPane().add(customerRoutingNumberTextField);
		
		librarianNameTextField = new JTextField();
		librarianNameTextField.setBounds(297, 133, 96, 19);
		frame.getContentPane().add(librarianNameTextField);
		librarianNameTextField.setColumns(10);
		
		librarianPayTextField = new JTextField();
		librarianPayTextField.setBounds(297, 171, 96, 19);
		frame.getContentPane().add(librarianPayTextField);
		librarianPayTextField.setColumns(10);
		
		JLabel librarianNameLabel = new JLabel("Name");
		librarianNameLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		librarianNameLabel.setBounds(228, 136, 45, 13);
		frame.getContentPane().add(librarianNameLabel);
		
		JLabel librarianpayLabel = new JLabel("PayRate");
		librarianpayLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		librarianpayLabel.setBounds(228, 174, 57, 13);
		frame.getContentPane().add(librarianpayLabel);
		
		titleTextField = new JTextField();
		titleTextField.setBounds(297, 257, 96, 19);
		frame.getContentPane().add(titleTextField);
		titleTextField.setColumns(10);
		
		authorTextField = new JTextField();
		authorTextField.setBounds(87, 298, 96, 19);
		frame.getContentPane().add(authorTextField);
		authorTextField.setColumns(10);
		
		ISBNTextField = new JTextField();
		ISBNTextField.setBounds(297, 298, 96, 19);
		frame.getContentPane().add(ISBNTextField);
		ISBNTextField.setColumns(10);
		
		JLabel titleLabel = new JLabel("Title");
		titleLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		titleLabel.setBounds(242, 260, 45, 13);
		frame.getContentPane().add(titleLabel);
		
		JLabel ISBNLabel = new JLabel("ISBN\r\n");
		ISBNLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		ISBNLabel.setBounds(242, 301, 45, 13);
		frame.getContentPane().add(ISBNLabel);
		
		JLabel authorLabel = new JLabel("Author");
		authorLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		authorLabel.setBounds(32, 301, 45, 13);
		frame.getContentPane().add(authorLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(474, 131, 2, 2);
		frame.getContentPane().add(scrollPane);
		
		
		
		
		
		
		
		
		
		
	}
}
