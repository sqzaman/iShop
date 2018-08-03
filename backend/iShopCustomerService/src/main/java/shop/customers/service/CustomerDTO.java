package shop.customers.service;

import java.util.ArrayList;
import java.util.List;


public class CustomerDTO {
	private String customerNumber;
	private String firstname;
	private String lastname;
	private String email;
	private String phone;

	private AddressDTO address;
	private AccountDTO account;
	private List<CreditCardDTO> creditcards = new ArrayList<CreditCardDTO>();

	public CustomerDTO(String customerNumber, String firstname, String lastname, String email, String phone) {
		super();
		this.customerNumber = customerNumber;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
	}

	public CustomerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		String result= "customer: "+customerNumber+" , "+firstname+" , "+lastname+" , "+email+" , "+phone;
		if (address != null) {
			result+="\n"+address;
		}
		if (account != null) {
			result+="\n"+account;
		}
		if (creditcards != null) {
			for (CreditCardDTO creditCard : creditcards )
				result+="\n"+creditCard;
		}
		return result;
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

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	public AccountDTO getAccount() {
		return account;
	}

	public void setAccount(AccountDTO account) {
		this.account = account;
	}

	public List<CreditCardDTO> getCreditcards() {
		return creditcards;
	}

	public void setCreditcards(List<CreditCardDTO> creditcards) {
		this.creditcards = creditcards;
	}

	public void addCreditCard(CreditCardDTO creditCard) {
		creditcards.add(creditCard);
	}
}
