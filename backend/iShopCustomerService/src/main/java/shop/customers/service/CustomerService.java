package shop.customers.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.customers.domain.Customer;
import shop.customers.repository.CustomerRepository;


@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;	
	
	public void addCustomer(CustomerDTO customer) {
		customerRepository.save(CustomerAdapter.getCustomer(customer));
	}

	public CustomerDTO getCustomer(String customerNumber) {
	  Optional<Customer> customerOptional = customerRepository.findById(customerNumber);
	  if (customerOptional.isPresent()) {
		  Customer customer = customerOptional.get();
		  return CustomerAdapter.getCustomerDTO(customer);
	  }
	  else
		  return null;
  }

	public OrderCustomerDTO getOrderCustomer(String customerNumber) {
		  Optional<Customer> customerOptional = customerRepository.findById(customerNumber);
		  if (customerOptional.isPresent()) {
			  Customer customer = customerOptional.get();
			  return OrderCustomerAdapter.getOrderCustomerDTO(customer);
		  }
		  else
			  return null;
	}
}
