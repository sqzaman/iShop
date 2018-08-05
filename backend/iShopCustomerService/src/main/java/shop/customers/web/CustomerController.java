package shop.customers.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import shop.customers.payload.CustomerSignUpRequest;
import shop.customers.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping(value = "/signup")
	public ResponseEntity<?> addCustomer(@Valid @RequestBody CustomerSignUpRequest customerSignUpRequest) {
		return customerService.createAccount(customerSignUpRequest);
	}
	
}
