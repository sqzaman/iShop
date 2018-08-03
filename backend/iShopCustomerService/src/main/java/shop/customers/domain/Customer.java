package shop.customers.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Customer {
	@Id
	private String customerNumber;
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	private Address address;
	private Account account;
	private List<CreditCard> creditcards = new ArrayList<CreditCard>();

	public Customer() {
	}

	public Customer(String customerNumber, String firstname, String lastname, String email, String phone) {
		super();
		this.customerNumber = customerNumber;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<CreditCard> getCreditcards() {
		return creditcards;
	}

	public void setCreditcards(List<CreditCard> creditcards) {
		this.creditcards = creditcards;
	}

	public void addCreditCard(CreditCard creditCard) {
		creditcards.add(creditCard);
	}
}
