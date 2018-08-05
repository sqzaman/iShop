package ishop.order.service;

import ishop.order.domain.Address;
import ishop.order.domain.Customer;

public class OrderCustomerAdapter {

	public static Customer getCustomer (OrderCustomerDTO customerDTO) {
		Customer customer = new Customer(
				customerDTO.getCustomerNumber(),
				customerDTO.getFirstname(),
				customerDTO.getLastname(),
				customerDTO.getEmail(),
				customerDTO.getPhone()				
				);
		Address addres = new Address(
				customerDTO.getStreet(),
				customerDTO.getCity(),
				customerDTO.getZip(),
				customerDTO.getCountry()
				);
		

		return customer;
	}
	
	public static OrderCustomerDTO getOrderCustomerDTO (Customer customer) {
		OrderCustomerDTO customerDTO = new OrderCustomerDTO(
				customer.getCustomerNumber(),
				customer.getFirstname(),
				customer.getLastname(),
				customer.getEmail(),
				customer.getPhone()				
				);
		if (customer.getAddress() != null) {
			customerDTO.setStreet(customer.getAddress().getStreet());
			customerDTO.setCity(customer.getAddress().getCity());
			customerDTO.setZip(customer.getAddress().getZip());
			customerDTO.setCountry(customer.getAddress().getCountry());
		}

		return customerDTO;
	}	
}
