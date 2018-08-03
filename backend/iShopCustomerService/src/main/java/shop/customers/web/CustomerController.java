package shop.customers.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import shop.customers.service.CustomerDTO;
import shop.customers.service.CustomerService;
import shop.customers.service.OrderCustomerDTO;

@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;

	@PostMapping("/add")
	public ResponseEntity<?> addCustomer(@RequestBody CustomerDTO customer) {
		customerService.addCustomer(customer);
		return new ResponseEntity<CustomerDTO>(HttpStatus.OK);
	}

	@GetMapping("/get/{customerNumber}")
	public ResponseEntity<?> getCustomer(@PathVariable String customerNumber) {
		CustomerDTO customer = customerService.getCustomer(customerNumber);
		if(customer != null)
		 return new ResponseEntity<CustomerDTO>(customerService.getCustomer(customerNumber),HttpStatus.OK);
		else
			return new ResponseEntity<String>("no customer found", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/get/ordercustomer/{customerNumber}")
	public ResponseEntity<?> getOrderCustomer(@PathVariable String customerNumber) {
		 return new ResponseEntity<OrderCustomerDTO>(customerService.getOrderCustomer(customerNumber),HttpStatus.OK);
	}
}
