package shop.customers.service;

import shop.customers.domain.CreditCard;
import shop.customers.domain.Customer;

public class CustomerAdapter {

	public static Customer getCustomer (CustomerDTO customerDTO) {
		Customer customer = new Customer(
				customerDTO.getCustomerNumber(),
				customerDTO.getFirstname(),
				customerDTO.getLastname(),
				customerDTO.getEmail(),
				customerDTO.getPhone()				
				);
		if (customerDTO.getAddress() != null) {
			customer.setAddress(AddressAdapter.getAddress(customerDTO.getAddress()) );
		}
		if (customerDTO.getAccount() != null) {
			customer.setAccount(AccountAdapter.getAccount(customerDTO.getAccount()));
		}
		if (customerDTO.getCreditcards() != null) {
			for (CreditCardDTO creditCardDTO : customerDTO.getCreditcards() )
			  customer.addCreditCard(CreditCardAdapter.getCreditCard(creditCardDTO));
		}
		return customer;
	}
	
	public static CustomerDTO getCustomerDTO (Customer customer) {
		CustomerDTO customerDTO = new CustomerDTO(
				customer.getCustomerNumber(),
				customer.getFirstname(),
				customer.getLastname(),
				customer.getEmail(),
				customer.getPhone()				
				);
		if (customer.getAddress() != null) {
			customerDTO.setAddress(AddressAdapter.getAddressDTO(customer.getAddress()) );
		}
		if (customer.getAccount() != null) {
			customerDTO.setAccount(AccountAdapter.getAccountDTO(customer.getAccount()));
		}
		if (customer.getCreditcards() != null) {
			for (CreditCard creditCard : customer.getCreditcards() )
				customerDTO.addCreditCard(CreditCardAdapter.getCreditCardDTO(creditCard));
		}
		return customerDTO;
	}
	
	
}
